package com.example.finalproject;

/*
public class staticrecyclerviewAdapter extends RecyclerView.Adapter <staticrecyclerviewAdapter.staticrecyclerviewholder>{
private ArrayList<staticrecyclerviewholder>items;
    int row_index;
    public staticrecyclerviewAdapter(ArrayList<com.example.plantsmenu.staticrecyclerviewholder> item) {
        this.items = items;
    }


    @NonNull
    @Override
    public staticrecyclerviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.staticrecycleritems,parent,false);
        staticrecyclerviewholder staticrecyclerviewholder=new staticrecyclerviewholder(view);
        return staticrecyclerviewholder;
    }

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull staticrecyclerviewholder holder, final int position) {
        staticrecyclerviewholder currentItem=items.get(position);
        holder.imageview.setImageResource(currentItem.getImage());
        holder.textview.setText(currentItem.getText());
        holder.linearlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//click on sortlist
                row_index = position;
                notifyDataSetChanged();
            }
        });
        //check if item selected
   if(row_index==position){
       holder.linearlayout.setBackgroundResource(R.drawable.static_recyclerview_bg);//add greencolor to selected list
   }
   else{
       holder.linearlayout.setBackgroundResource(R.drawable.static_recyclerview);//whiteclor list

   }

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class staticrecyclerviewholder extends RecyclerView.ViewHolder{
        TextView textview;
        ImageView imageview;
        LinearLayout linearlayout;
        private Object ImageView;
        private Object TextView;

        public staticrecyclerviewholder(@NonNull View itemView) {
        super(itemView);
        imageview=itemView.findViewById(R.id.allimage);
        textview=itemView.findViewById(R.id.all_text);
        linearlayout=itemView.findViewById(R.id.linear_layout);
    }

        public int getImage() {
        return (int) ImageView;
    }

        public int getText() {
       return (int) TextView;
        }
    }

}
*/
/*
public class staticrecyclerviewAdapter extends RecyclerView.Adapter<staticrecyclerviewAdapter.staticrecyclerviewholder> {
    private ArrayList <staticrecyclerviewholder> items;

    public staticrecyclerviewAdapter(ArrayList<staticrecyclerviewholder> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public staticrecyclerviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.staticrecycleritems,parent,false);
        staticrecyclerviewholder stRVholder=new staticrecyclerviewholder(view);
        return stRVholder;
    }

    @Override
    public void onBindViewHolder(@NonNull staticrecyclerviewholder holder, int position) {
          staticrecyclerviewholder currentItem=items.get(position);
         // holder.image.setImageResource(currentItem.getimage());
    }

    @Override
    public int getItemCount() {
        TextView text;
        ImageView image;
        RecyclerView sortlist1;
        //
        return 0;
    }

    class staticrecyclerviewholder extends RecyclerView.ViewHolder{
    TextView text;
    int image;
    public staticrecyclerviewholder(@NonNull View itemView) {
        super(itemView);
        image=itemView.findViewById(R.id.all_image);
        text=itemView.findViewById(R.id.all_text);

    }




    }

          }

   */
