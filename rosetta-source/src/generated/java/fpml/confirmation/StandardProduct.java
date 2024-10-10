package fpml.confirmation;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import fpml.confirmation.BasicQuotation;
import fpml.confirmation.CashflowNotional;
import fpml.confirmation.Product;
import fpml.confirmation.Product.ProductBuilder;
import fpml.confirmation.Product.ProductBuilderImpl;
import fpml.confirmation.Product.ProductImpl;
import fpml.confirmation.ProductModel;
import fpml.confirmation.StandardProduct;
import fpml.confirmation.StandardProduct.StandardProductBuilder;
import fpml.confirmation.StandardProduct.StandardProductBuilderImpl;
import fpml.confirmation.StandardProduct.StandardProductImpl;
import fpml.confirmation.meta.StandardProductMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Standard products - for use in Transparency reporting to define a product that represents a standardized OTC derivative transaction whose economics do not need to be fully described using an FpML schema because they are implied by the product ID. In other views, standard products are present for convenience to support internal messaging and workflows that are cross-product. Standard products are not full trade representations as such they are not intended to be used for confirming trades. Simple product representation providing key information about a variety of different products. Standard products - for use in Transparency reporting to define a product that represents a standardized OTC derivative transaction whose economics do not need to be fully described using an FpML schema because they are implied by the product ID. In other views, standard products are present for convenience to support internal messaging and workflows that are cross-product. Standard products are not full trade representations as such they are not intended to be used for confirming trades.
 * @version ${project.version}
 */
@RosettaDataType(value="StandardProduct", builder=StandardProduct.StandardProductBuilderImpl.class, version="${project.version}")
public interface StandardProduct extends Product {

	StandardProductMeta metaData = new StandardProductMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The notional amount that was traded.
	 */
	CashflowNotional getNotional();
	/**
	 * Pricing information for the trade.
	 */
	List<? extends BasicQuotation> getQuote();

	/*********************** Build Methods  ***********************/
	StandardProduct build();
	
	StandardProduct.StandardProductBuilder toBuilder();
	
	static StandardProduct.StandardProductBuilder builder() {
		return new StandardProduct.StandardProductBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends StandardProduct> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends StandardProduct> getType() {
		return StandardProduct.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("productModel"), processor, ProductModel.class, getProductModel());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("notional"), processor, CashflowNotional.class, getNotional());
		processRosetta(path.newSubPath("quote"), processor, BasicQuotation.class, getQuote());
	}
	

	/*********************** Builder Interface  ***********************/
	interface StandardProductBuilder extends StandardProduct, Product.ProductBuilder {
		CashflowNotional.CashflowNotionalBuilder getOrCreateNotional();
		CashflowNotional.CashflowNotionalBuilder getNotional();
		BasicQuotation.BasicQuotationBuilder getOrCreateQuote(int _index);
		List<? extends BasicQuotation.BasicQuotationBuilder> getQuote();
		StandardProduct.StandardProductBuilder setProductModel(ProductModel productModel);
		StandardProduct.StandardProductBuilder setId(String id);
		StandardProduct.StandardProductBuilder setNotional(CashflowNotional notional);
		StandardProduct.StandardProductBuilder addQuote(BasicQuotation quote0);
		StandardProduct.StandardProductBuilder addQuote(BasicQuotation quote1, int _idx);
		StandardProduct.StandardProductBuilder addQuote(List<? extends BasicQuotation> quote2);
		StandardProduct.StandardProductBuilder setQuote(List<? extends BasicQuotation> quote3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("productModel"), processor, ProductModel.ProductModelBuilder.class, getProductModel());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("notional"), processor, CashflowNotional.CashflowNotionalBuilder.class, getNotional());
			processRosetta(path.newSubPath("quote"), processor, BasicQuotation.BasicQuotationBuilder.class, getQuote());
		}
		

		StandardProduct.StandardProductBuilder prune();
	}

	/*********************** Immutable Implementation of StandardProduct  ***********************/
	class StandardProductImpl extends Product.ProductImpl implements StandardProduct {
		private final CashflowNotional notional;
		private final List<? extends BasicQuotation> quote;
		
		protected StandardProductImpl(StandardProduct.StandardProductBuilder builder) {
			super(builder);
			this.notional = ofNullable(builder.getNotional()).map(f->f.build()).orElse(null);
			this.quote = ofNullable(builder.getQuote()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("notional")
		public CashflowNotional getNotional() {
			return notional;
		}
		
		@Override
		@RosettaAttribute("quote")
		public List<? extends BasicQuotation> getQuote() {
			return quote;
		}
		
		@Override
		public StandardProduct build() {
			return this;
		}
		
		@Override
		public StandardProduct.StandardProductBuilder toBuilder() {
			StandardProduct.StandardProductBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(StandardProduct.StandardProductBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getNotional()).ifPresent(builder::setNotional);
			ofNullable(getQuote()).ifPresent(builder::setQuote);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			StandardProduct _that = getType().cast(o);
		
			if (!Objects.equals(notional, _that.getNotional())) return false;
			if (!ListEquals.listEquals(quote, _that.getQuote())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (notional != null ? notional.hashCode() : 0);
			_result = 31 * _result + (quote != null ? quote.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "StandardProduct {" +
				"notional=" + this.notional + ", " +
				"quote=" + this.quote +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of StandardProduct  ***********************/
	class StandardProductBuilderImpl extends Product.ProductBuilderImpl  implements StandardProduct.StandardProductBuilder {
	
		protected CashflowNotional.CashflowNotionalBuilder notional;
		protected List<BasicQuotation.BasicQuotationBuilder> quote = new ArrayList<>();
	
		public StandardProductBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("notional")
		public CashflowNotional.CashflowNotionalBuilder getNotional() {
			return notional;
		}
		
		@Override
		public CashflowNotional.CashflowNotionalBuilder getOrCreateNotional() {
			CashflowNotional.CashflowNotionalBuilder result;
			if (notional!=null) {
				result = notional;
			}
			else {
				result = notional = CashflowNotional.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("quote")
		public List<? extends BasicQuotation.BasicQuotationBuilder> getQuote() {
			return quote;
		}
		
		public BasicQuotation.BasicQuotationBuilder getOrCreateQuote(int _index) {
		
			if (quote==null) {
				this.quote = new ArrayList<>();
			}
			BasicQuotation.BasicQuotationBuilder result;
			return getIndex(quote, _index, () -> {
						BasicQuotation.BasicQuotationBuilder newQuote = BasicQuotation.builder();
						return newQuote;
					});
		}
		
		@Override
		@RosettaAttribute("productModel")
		public StandardProduct.StandardProductBuilder setProductModel(ProductModel productModel) {
			this.productModel = productModel==null?null:productModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public StandardProduct.StandardProductBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("notional")
		public StandardProduct.StandardProductBuilder setNotional(CashflowNotional notional) {
			this.notional = notional==null?null:notional.toBuilder();
			return this;
		}
		@Override
		public StandardProduct.StandardProductBuilder addQuote(BasicQuotation quote) {
			if (quote!=null) this.quote.add(quote.toBuilder());
			return this;
		}
		
		@Override
		public StandardProduct.StandardProductBuilder addQuote(BasicQuotation quote, int _idx) {
			getIndex(this.quote, _idx, () -> quote.toBuilder());
			return this;
		}
		@Override 
		public StandardProduct.StandardProductBuilder addQuote(List<? extends BasicQuotation> quotes) {
			if (quotes != null) {
				for (BasicQuotation toAdd : quotes) {
					this.quote.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("quote")
		public StandardProduct.StandardProductBuilder setQuote(List<? extends BasicQuotation> quotes) {
			if (quotes == null)  {
				this.quote = new ArrayList<>();
			}
			else {
				this.quote = quotes.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public StandardProduct build() {
			return new StandardProduct.StandardProductImpl(this);
		}
		
		@Override
		public StandardProduct.StandardProductBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public StandardProduct.StandardProductBuilder prune() {
			super.prune();
			if (notional!=null && !notional.prune().hasData()) notional = null;
			quote = quote.stream().filter(b->b!=null).<BasicQuotation.BasicQuotationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getNotional()!=null && getNotional().hasData()) return true;
			if (getQuote()!=null && getQuote().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public StandardProduct.StandardProductBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			StandardProduct.StandardProductBuilder o = (StandardProduct.StandardProductBuilder) other;
			
			merger.mergeRosetta(getNotional(), o.getNotional(), this::setNotional);
			merger.mergeRosetta(getQuote(), o.getQuote(), this::getOrCreateQuote);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			StandardProduct _that = getType().cast(o);
		
			if (!Objects.equals(notional, _that.getNotional())) return false;
			if (!ListEquals.listEquals(quote, _that.getQuote())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (notional != null ? notional.hashCode() : 0);
			_result = 31 * _result + (quote != null ? quote.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "StandardProductBuilder {" +
				"notional=" + this.notional + ", " +
				"quote=" + this.quote +
			'}' + " " + super.toString();
		}
	}
}
