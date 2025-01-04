// Krushals Algorithms Code

/*
 package graphs;

class Edge implements Comparable<Edge> {
int v1; 
int v2; 
int weight;

Edge(int v1, int v2, int weight) {
this.v1 = v1; 
this.v2 = v2; 
this.weight = weight;
}

@Override
public int compareTo(Edge o) {
return this.weight - o.weight;
}

}
public class KruskalAlgorithm {

private static int findParent(int v, int parent[]) {
if(v == parent[v]){
return v;
}
return findParent(parent[v], parent);
}

public static Edge[] kruskalAlgorithm(Edge[] edges, int n) {
Arrays.sort(edges); 
Edge mst[] = new Edge[n - 1]; 
int parent[] = new int[n]; 
for(int j = 0; j<n; j++){
parent[j] = j;
}

int count = 0, i = 0; 
while(count != n - 1){
Edge curentEdge = edges[i++]; 
int v1Parent = findParent(curentEdge.v1, parent); 
int v2Parent = findParent(curentEdge.v2, parent); 
if(v1Parent != v2Parent){
// Including currentEdge 
mst[count] = curentEdge; 
count++; 
parent[v1Parent] = v2Parent;
}
}
return mst;
}

public static void main(String[] args) {
Scanner s = new Scanner(System.in); 
int n = s.nextInt(); 
int e = s.nextInt();

Edge edges[] = new Edge[e]; 
for(int i = 0; i <e; i++){
int v1 = s.nextInt(); 
int v2 = s.nextInt(); 
int weight = s.nextInt(); 
Edge edge = new Edge(v1, v2, weight); 
edges[i] = edge;
}
Edge mst[] = kruskalAlgorithm(edges, n); 
for(int i = 0; i < mst.length; i++){ 
if(mst[i].v1 < mst[i].v2){
System.out.println(mst[i].v1 + mst[i].v2 +" " + mst[i].weight); 
}else{
System.out.println(mst[i].v2 + mst[i].v1 +"  " + mst[i].weight);
}
}
}
}
 */

 // Prims Alogorithms code
 /*
  package graphs;

import java.util.Scanner;

public class PrimsAlgorithm {

private static int findMinVertex(boolean[] visited, int[] weight) {

int minVertex = -1; 
for(int i = 0; i < visited.length; i++){ 
if(!visited[i] && (minVertex ==-1 || weight[i] < weight[minVertex])){
minVertex = i;
}
}
return minVertex;
}

public static void prims(int adjMatrix[][]){
int n = adjMatrix.length; 
boolean visited[][] = new boolean[n]; 
int parent[] = new int[n]; 
int weight[] = new int[n]; 
// source - vertex 0 
parent[0] = -1; 
weight[0] = 0; 
for(int i = 1; i <n; i++){
weight[i] = Integer.MAX_VALUE;
}
for(int i = 0; i<n; i++){
int minVertex = findMinVertex(visited, weight); 
visited[minVertex] = true; 
// Explore neighbors of min vertx 
for(int j = 0; j<n; j++){ 
if(adjMatrix[minVertex][j] != 0 && !visited[j]){ 
if(weight[j] > adjMatrix[minVertex][j]){
// update values 
weight[j] = adjMatrix[minVertex][j]; 
parent[j] = minVertex;
}
}
}
}
// Print MST 
for(int i = 1; i <n; i++){ 
if(i < parent[i]){
System.out.println(i + " " + parent[i] +" " + weight[i]); 
}else{
System.out.println(parent[i] + " " + i +" " + weight[i]);
}
}
}

public static void main(String[] args) {

Scanner s = new Scanner(System.in); 
int n = s.nextInt(); 
int e = s.nextInt(); 
int adjMatrix[][] = new int[n][n]; 
for(int i = 0; i < e; i++){
int v1 = s.nextInt(); 
int v2 = s.nextInt(); 
int weight = s.nextInt(); 
adjMatrix[v1][v2] = weight; 
adjMatrix[v2][v1] = weight;
}
prims(adjMatrix);
}
}
  */

  // Complexity of Prims 
  /*
   package graphs;

import java.util.Scanner;

public class PrimsAlgorithm {

private static int findMinVertex(boolean[] visited, int[] weight) {

int minVertex = -1; 
for(int i = 0; i < visited.length; i++){ 
if(!visited[i] && (minVertex ==-1 || weight[i] < weight[minVertex])){
minVertex = i;
}
}
return minVertex;
}

public static void prims(int adjMatrix[][]){
int n = adjMatrix.length; 
boolean visited[][] = new boolean[n]; 
int parent[] = new int[n]; 
int weight[] = new int[n]; 
// source - vertex 0 
parent[0] = -1; 
weight[0] = 0; 
for(int i = 1; i <n; i++){
weight[i] = Integer.MAX_VALUE;
}
for(int i = 0; i<n; i++){
int minVertex = findMinVertex(visited, weight); 
visited[minVertex] = true; 
// Explore neighbors of min vertx 
for(int j = 0; j<n; j++){ 
if(adjMatrix[minVertex][j] != 0 && !visited[j]){ 
if(weight[j] > adjMatrix[minVertex][j]){
// update values 
weight[j] = adjMatrix[minVertex][j]; 
parent[j] = minVertex;
}
}
}
}
// Print MST 
for(int i = 1; i <n; i++){ 
if(i < parent[i]){
System.out.println(i + " " + parent[i] +" " + weight[i]); 
}else{
System.out.println(parent[i] + " " + i +" " + weight[i]);
}
}
}

public static void main(String[] args) {

Scanner s = new Scanner(System.in); 
int n = s.nextInt(); 
int e = s.nextInt(); 
int adjMatrix[][] = new int[n][n]; 
for(int i = 0; i < e; i++){
int v1 = s.nextInt(); 
int v2 = s.nextInt(); 
int weight = s.nextInt(); 
adjMatrix[v1][v2] = weight; 
adjMatrix[v2][v1] = weight;
}
prims(adjMatrix);
}
}
   */

   // Dijkstras Algo code
   /*
    package graphs;

import java.util.Scanner;

public class DijkstraAlgorithm {

private static int findMinVertex(boolean[] visited, int[] distance) {

int minVertex = -1; 
for(int i = 0; i < visited.length; i++){ 
if(!visited[i] && (minVertex ==-1 || distance[i] < distance[minVertex]))
{
minVertex = i;
}
}
return minVertex;
}

public static void dijkstra(int adjMatrix[][]){
int n = adjMatrix.length; 
boolean visited[] = new boolean[n]; 
int distance[] = new int[n]; 
distance[0] = 0; 
for(int i = 1; i<n; i++){
distance[i] = Integer.MAX_VALUE;
}

for(int i = 0; i < n-1; i++){
int minVertex = findMinVertex(visited, distance); 
visited[minVertex] = true; 
for(int j = 0; j<n; j++){ 
if(adjMatrix[minVertex][j] > 0 && !visited[j] && adjMatrix[minVertex][j] < Integer .MAX_VALUE){
// j is Unvisited neighbor of minVertex 
// Calculate distance to reach j from source via minVertex 
int newDist = distance[minVertex] + adjMatrix[minVertex][j]; 
if(newDist < distance[j]){
distance[j] = newDist;
}
}
}
}
// Print Distance values for all vertices
for(int i=0;i<n;i++){
System.out.println(i+" "+ distance[i]);
}
}


public static void main(String[] args) {

Scanner s = new Scanner(System.in); 
int n = s.nextInt(); 
int e = s.nextInt(); 
int adjMatrix[][] = new int[n][n]; 
for(int i = 0; i < e; i++){
int v1 = s.nextInt(); 
int v2 = s.nextInt(); 
int weight = s.nextInt(); 
adjMatrix[v1][v2] = weight; 
adjMatrix[v2][v1] = weight;
}
dijkstra(adjMatrix);
}
}
    */

    // complexity of Dijkstra code
    /*
     package graphs;

import java.util.Scanner;

public class DijkstraAlgorithm {

private static int findMinVertex(boolean[] visited, int[] distance) {

int minVertex = -1; 
for(int i = 0; i < visited.length; i++){ 
if(!visited[i] && (minVertex ==-1 || distance[i] < distance[minVertex]))
{
minVertex = i;
}
}
return minVertex;
}

public static void dijkstra(int adjMatrix[][]){
int n = adjMatrix.length; 
boolean visited[] = new boolean[n]; 
int distance[] = new int[n]; 
distance[0] = 0; 
for(int i = 1; i<n; i++){
distance[i] = Integer.MAX_VALUE;
}

for(int i = 0; i < n-1; i++){
int minVertex = findMinVertex(visited, distance); 
visited[minVertex] = true; 
for(int j = 0; j<n; j++){ 
if(adjMatrix[minVertex][j] > 0 && !visited[j] && adjMatrix[minVertex][j] < Integer .MAX_VALUE){
// j is Unvisited neighbor of minVertex 
// Calculate distance to reach j from source via minVertex 
int newDist = distance[minVertex] + adjMatrix[minVertex][j]; 
if(newDist < distance[j]){
distance[j] = newDist;
}
}
}
}
// Print Distance values for all vertices
for(int i=0;i<n;i++){
System.out.println(i+" "+ distance[i]);
}
}


public static void main(String[] args) {

Scanner s = new Scanner(System.in); 
int n = s.nextInt(); 
int e = s.nextInt(); 
int adjMatrix[][] = new int[n][n]; 
for(int i = 0; i < e; i++){
int v1 = s.nextInt(); 
int v2 = s.nextInt(); 
int weight = s.nextInt(); 
adjMatrix[v1][v2] = weight; 
adjMatrix[v2][v1] = weight;
}
dijkstra(adjMatrix);
}
}
     */

     