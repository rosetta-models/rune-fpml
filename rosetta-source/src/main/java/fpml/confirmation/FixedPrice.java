package fpml.confirmation;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.confirmation.FixedPrice;
import fpml.confirmation.FixedPrice.FixedPriceBuilder;
import fpml.confirmation.FixedPrice.FixedPriceBuilderImpl;
import fpml.confirmation.FixedPrice.FixedPriceImpl;
import fpml.confirmation.PriceModel;
import fpml.confirmation.meta.FixedPriceMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type defining the Fixed Price.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="FixedPrice", builder=FixedPrice.FixedPriceBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface FixedPrice extends RosettaModelObject {

	FixedPriceMeta metaData = new FixedPriceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The Fixed Price.
	 */
	BigDecimal getPrice();
	PriceModel getPriceModel();
	String getId();

	/*********************** Build Methods  ***********************/
	FixedPrice build();
	
	FixedPrice.FixedPriceBuilder toBuilder();
	
	static FixedPrice.FixedPriceBuilder builder() {
		return new FixedPrice.FixedPriceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FixedPrice> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FixedPrice> getType() {
		return FixedPrice.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("price"), BigDecimal.class, getPrice(), this);
		processRosetta(path.newSubPath("priceModel"), processor, PriceModel.class, getPriceModel());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FixedPriceBuilder extends FixedPrice, RosettaModelObjectBuilder {
		PriceModel.PriceModelBuilder getOrCreatePriceModel();
		PriceModel.PriceModelBuilder getPriceModel();
		FixedPrice.FixedPriceBuilder setPrice(BigDecimal price);
		FixedPrice.FixedPriceBuilder setPriceModel(PriceModel priceModel);
		FixedPrice.FixedPriceBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("price"), BigDecimal.class, getPrice(), this);
			processRosetta(path.newSubPath("priceModel"), processor, PriceModel.PriceModelBuilder.class, getPriceModel());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		FixedPrice.FixedPriceBuilder prune();
	}

	/*********************** Immutable Implementation of FixedPrice  ***********************/
	class FixedPriceImpl implements FixedPrice {
		private final BigDecimal price;
		private final PriceModel priceModel;
		private final String id;
		
		protected FixedPriceImpl(FixedPrice.FixedPriceBuilder builder) {
			this.price = builder.getPrice();
			this.priceModel = ofNullable(builder.getPriceModel()).map(f->f.build()).orElse(null);
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("price")
		public BigDecimal getPrice() {
			return price;
		}
		
		@Override
		@RosettaAttribute("priceModel")
		public PriceModel getPriceModel() {
			return priceModel;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public FixedPrice build() {
			return this;
		}
		
		@Override
		public FixedPrice.FixedPriceBuilder toBuilder() {
			FixedPrice.FixedPriceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FixedPrice.FixedPriceBuilder builder) {
			ofNullable(getPrice()).ifPresent(builder::setPrice);
			ofNullable(getPriceModel()).ifPresent(builder::setPriceModel);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FixedPrice _that = getType().cast(o);
		
			if (!Objects.equals(price, _that.getPrice())) return false;
			if (!Objects.equals(priceModel, _that.getPriceModel())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (price != null ? price.hashCode() : 0);
			_result = 31 * _result + (priceModel != null ? priceModel.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FixedPrice {" +
				"price=" + this.price + ", " +
				"priceModel=" + this.priceModel + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of FixedPrice  ***********************/
	class FixedPriceBuilderImpl implements FixedPrice.FixedPriceBuilder {
	
		protected BigDecimal price;
		protected PriceModel.PriceModelBuilder priceModel;
		protected String id;
	
		public FixedPriceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("price")
		public BigDecimal getPrice() {
			return price;
		}
		
		@Override
		@RosettaAttribute("priceModel")
		public PriceModel.PriceModelBuilder getPriceModel() {
			return priceModel;
		}
		
		@Override
		public PriceModel.PriceModelBuilder getOrCreatePriceModel() {
			PriceModel.PriceModelBuilder result;
			if (priceModel!=null) {
				result = priceModel;
			}
			else {
				result = priceModel = PriceModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("price")
		public FixedPrice.FixedPriceBuilder setPrice(BigDecimal price) {
			this.price = price==null?null:price;
			return this;
		}
		@Override
		@RosettaAttribute("priceModel")
		public FixedPrice.FixedPriceBuilder setPriceModel(PriceModel priceModel) {
			this.priceModel = priceModel==null?null:priceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public FixedPrice.FixedPriceBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public FixedPrice build() {
			return new FixedPrice.FixedPriceImpl(this);
		}
		
		@Override
		public FixedPrice.FixedPriceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FixedPrice.FixedPriceBuilder prune() {
			if (priceModel!=null && !priceModel.prune().hasData()) priceModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPrice()!=null) return true;
			if (getPriceModel()!=null && getPriceModel().hasData()) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FixedPrice.FixedPriceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FixedPrice.FixedPriceBuilder o = (FixedPrice.FixedPriceBuilder) other;
			
			merger.mergeRosetta(getPriceModel(), o.getPriceModel(), this::setPriceModel);
			
			merger.mergeBasic(getPrice(), o.getPrice(), this::setPrice);
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FixedPrice _that = getType().cast(o);
		
			if (!Objects.equals(price, _that.getPrice())) return false;
			if (!Objects.equals(priceModel, _that.getPriceModel())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (price != null ? price.hashCode() : 0);
			_result = 31 * _result + (priceModel != null ? priceModel.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FixedPriceBuilder {" +
				"price=" + this.price + ", " +
				"priceModel=" + this.priceModel + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
