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
import fpml.confirmation.CommodityProductModel;
import fpml.confirmation.CommodityProductModel.CommodityProductModelBuilder;
import fpml.confirmation.CommodityProductModel.CommodityProductModelBuilderImpl;
import fpml.confirmation.CommodityProductModel.CommodityProductModelImpl;
import fpml.confirmation.CommodityProductModelSequence;
import fpml.confirmation.CommodityReferencePriceFrameworkModel;
import fpml.confirmation.SpecifiedPriceEnum;
import fpml.confirmation.meta.CommodityProductModelMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A group used to specify details of a commodity underlyer.
 * @version ${project.version}
 */
@RosettaDataType(value="CommodityProductModel", builder=CommodityProductModel.CommodityProductModelBuilderImpl.class, version="${project.version}")
public interface CommodityProductModel extends RosettaModelObject {

	CommodityProductModelMeta metaData = new CommodityProductModelMeta();

	/*********************** Getter Methods  ***********************/
	CommodityReferencePriceFrameworkModel getCommodityReferencePriceFrameworkModel();
	/**
	 * The &#39;specified Price&#39; describes the nature of the underlying price that is observed. It must be be stated in the underlyer definition as it is not defined in the Commodity Reference Price. Example values of &#39;specifiedPrice&#39; are &#39;Settlement&#39; (for a futures contract) and &#39;WeightedAverage&#39; (for some published prices and indices).
	 */
	SpecifiedPriceEnum getSpecifiedPrice();
	CommodityProductModelSequence getCommodityProductModelSequence();
	/**
	 * The &#39;multiplier&#39; specifies the multiplier associated with the Transaction. The &#39;multiplier&#39; element has two uses: (1) for Freight Transactions or any Calculation Period specified for a Freight Transaction, if an amount is specified as the Multiplier then it is captured by this element and (2) if the Transaction is a heat rate option, the heat rate multiplier is represented in this element. If multiplier is not provided, multiplier is assumed to be 1. (i.e. rate source states 1 BBL of Oil as 90 Dollars. Multiplier of 10 will change the value to 900 dollars.)
	 */
	BigDecimal getMultiplier();

	/*********************** Build Methods  ***********************/
	CommodityProductModel build();
	
	CommodityProductModel.CommodityProductModelBuilder toBuilder();
	
	static CommodityProductModel.CommodityProductModelBuilder builder() {
		return new CommodityProductModel.CommodityProductModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityProductModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityProductModel> getType() {
		return CommodityProductModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("commodityReferencePriceFrameworkModel"), processor, CommodityReferencePriceFrameworkModel.class, getCommodityReferencePriceFrameworkModel());
		processor.processBasic(path.newSubPath("specifiedPrice"), SpecifiedPriceEnum.class, getSpecifiedPrice(), this);
		processRosetta(path.newSubPath("commodityProductModelSequence"), processor, CommodityProductModelSequence.class, getCommodityProductModelSequence());
		processor.processBasic(path.newSubPath("multiplier"), BigDecimal.class, getMultiplier(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityProductModelBuilder extends CommodityProductModel, RosettaModelObjectBuilder {
		CommodityReferencePriceFrameworkModel.CommodityReferencePriceFrameworkModelBuilder getOrCreateCommodityReferencePriceFrameworkModel();
		CommodityReferencePriceFrameworkModel.CommodityReferencePriceFrameworkModelBuilder getCommodityReferencePriceFrameworkModel();
		CommodityProductModelSequence.CommodityProductModelSequenceBuilder getOrCreateCommodityProductModelSequence();
		CommodityProductModelSequence.CommodityProductModelSequenceBuilder getCommodityProductModelSequence();
		CommodityProductModel.CommodityProductModelBuilder setCommodityReferencePriceFrameworkModel(CommodityReferencePriceFrameworkModel commodityReferencePriceFrameworkModel);
		CommodityProductModel.CommodityProductModelBuilder setSpecifiedPrice(SpecifiedPriceEnum specifiedPrice);
		CommodityProductModel.CommodityProductModelBuilder setCommodityProductModelSequence(CommodityProductModelSequence commodityProductModelSequence);
		CommodityProductModel.CommodityProductModelBuilder setMultiplier(BigDecimal multiplier);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("commodityReferencePriceFrameworkModel"), processor, CommodityReferencePriceFrameworkModel.CommodityReferencePriceFrameworkModelBuilder.class, getCommodityReferencePriceFrameworkModel());
			processor.processBasic(path.newSubPath("specifiedPrice"), SpecifiedPriceEnum.class, getSpecifiedPrice(), this);
			processRosetta(path.newSubPath("commodityProductModelSequence"), processor, CommodityProductModelSequence.CommodityProductModelSequenceBuilder.class, getCommodityProductModelSequence());
			processor.processBasic(path.newSubPath("multiplier"), BigDecimal.class, getMultiplier(), this);
		}
		

		CommodityProductModel.CommodityProductModelBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityProductModel  ***********************/
	class CommodityProductModelImpl implements CommodityProductModel {
		private final CommodityReferencePriceFrameworkModel commodityReferencePriceFrameworkModel;
		private final SpecifiedPriceEnum specifiedPrice;
		private final CommodityProductModelSequence commodityProductModelSequence;
		private final BigDecimal multiplier;
		
		protected CommodityProductModelImpl(CommodityProductModel.CommodityProductModelBuilder builder) {
			this.commodityReferencePriceFrameworkModel = ofNullable(builder.getCommodityReferencePriceFrameworkModel()).map(f->f.build()).orElse(null);
			this.specifiedPrice = builder.getSpecifiedPrice();
			this.commodityProductModelSequence = ofNullable(builder.getCommodityProductModelSequence()).map(f->f.build()).orElse(null);
			this.multiplier = builder.getMultiplier();
		}
		
		@Override
		@RosettaAttribute("commodityReferencePriceFrameworkModel")
		public CommodityReferencePriceFrameworkModel getCommodityReferencePriceFrameworkModel() {
			return commodityReferencePriceFrameworkModel;
		}
		
		@Override
		@RosettaAttribute("specifiedPrice")
		public SpecifiedPriceEnum getSpecifiedPrice() {
			return specifiedPrice;
		}
		
		@Override
		@RosettaAttribute("commodityProductModelSequence")
		public CommodityProductModelSequence getCommodityProductModelSequence() {
			return commodityProductModelSequence;
		}
		
		@Override
		@RosettaAttribute("multiplier")
		public BigDecimal getMultiplier() {
			return multiplier;
		}
		
		@Override
		public CommodityProductModel build() {
			return this;
		}
		
		@Override
		public CommodityProductModel.CommodityProductModelBuilder toBuilder() {
			CommodityProductModel.CommodityProductModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityProductModel.CommodityProductModelBuilder builder) {
			ofNullable(getCommodityReferencePriceFrameworkModel()).ifPresent(builder::setCommodityReferencePriceFrameworkModel);
			ofNullable(getSpecifiedPrice()).ifPresent(builder::setSpecifiedPrice);
			ofNullable(getCommodityProductModelSequence()).ifPresent(builder::setCommodityProductModelSequence);
			ofNullable(getMultiplier()).ifPresent(builder::setMultiplier);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityProductModel _that = getType().cast(o);
		
			if (!Objects.equals(commodityReferencePriceFrameworkModel, _that.getCommodityReferencePriceFrameworkModel())) return false;
			if (!Objects.equals(specifiedPrice, _that.getSpecifiedPrice())) return false;
			if (!Objects.equals(commodityProductModelSequence, _that.getCommodityProductModelSequence())) return false;
			if (!Objects.equals(multiplier, _that.getMultiplier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (commodityReferencePriceFrameworkModel != null ? commodityReferencePriceFrameworkModel.hashCode() : 0);
			_result = 31 * _result + (specifiedPrice != null ? specifiedPrice.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (commodityProductModelSequence != null ? commodityProductModelSequence.hashCode() : 0);
			_result = 31 * _result + (multiplier != null ? multiplier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityProductModel {" +
				"commodityReferencePriceFrameworkModel=" + this.commodityReferencePriceFrameworkModel + ", " +
				"specifiedPrice=" + this.specifiedPrice + ", " +
				"commodityProductModelSequence=" + this.commodityProductModelSequence + ", " +
				"multiplier=" + this.multiplier +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityProductModel  ***********************/
	class CommodityProductModelBuilderImpl implements CommodityProductModel.CommodityProductModelBuilder {
	
		protected CommodityReferencePriceFrameworkModel.CommodityReferencePriceFrameworkModelBuilder commodityReferencePriceFrameworkModel;
		protected SpecifiedPriceEnum specifiedPrice;
		protected CommodityProductModelSequence.CommodityProductModelSequenceBuilder commodityProductModelSequence;
		protected BigDecimal multiplier;
	
		public CommodityProductModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("commodityReferencePriceFrameworkModel")
		public CommodityReferencePriceFrameworkModel.CommodityReferencePriceFrameworkModelBuilder getCommodityReferencePriceFrameworkModel() {
			return commodityReferencePriceFrameworkModel;
		}
		
		@Override
		public CommodityReferencePriceFrameworkModel.CommodityReferencePriceFrameworkModelBuilder getOrCreateCommodityReferencePriceFrameworkModel() {
			CommodityReferencePriceFrameworkModel.CommodityReferencePriceFrameworkModelBuilder result;
			if (commodityReferencePriceFrameworkModel!=null) {
				result = commodityReferencePriceFrameworkModel;
			}
			else {
				result = commodityReferencePriceFrameworkModel = CommodityReferencePriceFrameworkModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("specifiedPrice")
		public SpecifiedPriceEnum getSpecifiedPrice() {
			return specifiedPrice;
		}
		
		@Override
		@RosettaAttribute("commodityProductModelSequence")
		public CommodityProductModelSequence.CommodityProductModelSequenceBuilder getCommodityProductModelSequence() {
			return commodityProductModelSequence;
		}
		
		@Override
		public CommodityProductModelSequence.CommodityProductModelSequenceBuilder getOrCreateCommodityProductModelSequence() {
			CommodityProductModelSequence.CommodityProductModelSequenceBuilder result;
			if (commodityProductModelSequence!=null) {
				result = commodityProductModelSequence;
			}
			else {
				result = commodityProductModelSequence = CommodityProductModelSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("multiplier")
		public BigDecimal getMultiplier() {
			return multiplier;
		}
		
		@Override
		@RosettaAttribute("commodityReferencePriceFrameworkModel")
		public CommodityProductModel.CommodityProductModelBuilder setCommodityReferencePriceFrameworkModel(CommodityReferencePriceFrameworkModel commodityReferencePriceFrameworkModel) {
			this.commodityReferencePriceFrameworkModel = commodityReferencePriceFrameworkModel==null?null:commodityReferencePriceFrameworkModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("specifiedPrice")
		public CommodityProductModel.CommodityProductModelBuilder setSpecifiedPrice(SpecifiedPriceEnum specifiedPrice) {
			this.specifiedPrice = specifiedPrice==null?null:specifiedPrice;
			return this;
		}
		@Override
		@RosettaAttribute("commodityProductModelSequence")
		public CommodityProductModel.CommodityProductModelBuilder setCommodityProductModelSequence(CommodityProductModelSequence commodityProductModelSequence) {
			this.commodityProductModelSequence = commodityProductModelSequence==null?null:commodityProductModelSequence.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("multiplier")
		public CommodityProductModel.CommodityProductModelBuilder setMultiplier(BigDecimal multiplier) {
			this.multiplier = multiplier==null?null:multiplier;
			return this;
		}
		
		@Override
		public CommodityProductModel build() {
			return new CommodityProductModel.CommodityProductModelImpl(this);
		}
		
		@Override
		public CommodityProductModel.CommodityProductModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityProductModel.CommodityProductModelBuilder prune() {
			if (commodityReferencePriceFrameworkModel!=null && !commodityReferencePriceFrameworkModel.prune().hasData()) commodityReferencePriceFrameworkModel = null;
			if (commodityProductModelSequence!=null && !commodityProductModelSequence.prune().hasData()) commodityProductModelSequence = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCommodityReferencePriceFrameworkModel()!=null && getCommodityReferencePriceFrameworkModel().hasData()) return true;
			if (getSpecifiedPrice()!=null) return true;
			if (getCommodityProductModelSequence()!=null && getCommodityProductModelSequence().hasData()) return true;
			if (getMultiplier()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityProductModel.CommodityProductModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityProductModel.CommodityProductModelBuilder o = (CommodityProductModel.CommodityProductModelBuilder) other;
			
			merger.mergeRosetta(getCommodityReferencePriceFrameworkModel(), o.getCommodityReferencePriceFrameworkModel(), this::setCommodityReferencePriceFrameworkModel);
			merger.mergeRosetta(getCommodityProductModelSequence(), o.getCommodityProductModelSequence(), this::setCommodityProductModelSequence);
			
			merger.mergeBasic(getSpecifiedPrice(), o.getSpecifiedPrice(), this::setSpecifiedPrice);
			merger.mergeBasic(getMultiplier(), o.getMultiplier(), this::setMultiplier);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityProductModel _that = getType().cast(o);
		
			if (!Objects.equals(commodityReferencePriceFrameworkModel, _that.getCommodityReferencePriceFrameworkModel())) return false;
			if (!Objects.equals(specifiedPrice, _that.getSpecifiedPrice())) return false;
			if (!Objects.equals(commodityProductModelSequence, _that.getCommodityProductModelSequence())) return false;
			if (!Objects.equals(multiplier, _that.getMultiplier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (commodityReferencePriceFrameworkModel != null ? commodityReferencePriceFrameworkModel.hashCode() : 0);
			_result = 31 * _result + (specifiedPrice != null ? specifiedPrice.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (commodityProductModelSequence != null ? commodityProductModelSequence.hashCode() : 0);
			_result = 31 * _result + (multiplier != null ? multiplier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityProductModelBuilder {" +
				"commodityReferencePriceFrameworkModel=" + this.commodityReferencePriceFrameworkModel + ", " +
				"specifiedPrice=" + this.specifiedPrice + ", " +
				"commodityProductModelSequence=" + this.commodityProductModelSequence + ", " +
				"multiplier=" + this.multiplier +
			'}';
		}
	}
}
