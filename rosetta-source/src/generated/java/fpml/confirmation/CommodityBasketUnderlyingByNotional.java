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
import fpml.confirmation.AveragingMethodEnum;
import fpml.confirmation.Commodity;
import fpml.confirmation.CommodityBasketUnderlyingBase;
import fpml.confirmation.CommodityBasketUnderlyingBase.CommodityBasketUnderlyingBaseBuilder;
import fpml.confirmation.CommodityBasketUnderlyingBase.CommodityBasketUnderlyingBaseBuilderImpl;
import fpml.confirmation.CommodityBasketUnderlyingBase.CommodityBasketUnderlyingBaseImpl;
import fpml.confirmation.CommodityBasketUnderlyingByNotional;
import fpml.confirmation.CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilder;
import fpml.confirmation.CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilderImpl;
import fpml.confirmation.CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalImpl;
import fpml.confirmation.CommodityFx;
import fpml.confirmation.CommodityNotionalQuantityModel;
import fpml.confirmation.CommodityPricingDates;
import fpml.confirmation.PayerReceiverEnum;
import fpml.confirmation.meta.CommodityBasketUnderlyingByNotionalMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="CommodityBasketUnderlyingByNotional", builder=CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilderImpl.class, version="${project.version}")
public interface CommodityBasketUnderlyingByNotional extends CommodityBasketUnderlyingBase {

	CommodityBasketUnderlyingByNotionalMeta metaData = new CommodityBasketUnderlyingByNotionalMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * FX observations to be used to convert the observed Commodity Reference Price to the Settlement Currency.
	 */
	CommodityFx getFx();
	/**
	 * If the Notional Quantity is specified in a unit that does not match the unit in which the Commodity Reference Price is quoted, the scaling or conversion factor used to convert the Commodity Reference Price unit into the Notional Quantity unit should be stated here. If there is no conversion, this element is not intended to be used.
	 */
	BigDecimal getConversionFactor();
	CommodityNotionalQuantityModel getCommodityNotionalQuantityModel();

	/*********************** Build Methods  ***********************/
	CommodityBasketUnderlyingByNotional build();
	
	CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilder toBuilder();
	
	static CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilder builder() {
		return new CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityBasketUnderlyingByNotional> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityBasketUnderlyingByNotional> getType() {
		return CommodityBasketUnderlyingByNotional.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("direction"), PayerReceiverEnum.class, getDirection(), this);
		processRosetta(path.newSubPath("commodity"), processor, Commodity.class, getCommodity());
		processRosetta(path.newSubPath("pricingDates"), processor, CommodityPricingDates.class, getPricingDates());
		processor.processBasic(path.newSubPath("averagingMethod"), AveragingMethodEnum.class, getAveragingMethod(), this);
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("fx"), processor, CommodityFx.class, getFx());
		processor.processBasic(path.newSubPath("conversionFactor"), BigDecimal.class, getConversionFactor(), this);
		processRosetta(path.newSubPath("commodityNotionalQuantityModel"), processor, CommodityNotionalQuantityModel.class, getCommodityNotionalQuantityModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityBasketUnderlyingByNotionalBuilder extends CommodityBasketUnderlyingByNotional, CommodityBasketUnderlyingBase.CommodityBasketUnderlyingBaseBuilder {
		CommodityFx.CommodityFxBuilder getOrCreateFx();
		CommodityFx.CommodityFxBuilder getFx();
		CommodityNotionalQuantityModel.CommodityNotionalQuantityModelBuilder getOrCreateCommodityNotionalQuantityModel();
		CommodityNotionalQuantityModel.CommodityNotionalQuantityModelBuilder getCommodityNotionalQuantityModel();
		CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilder setDirection(PayerReceiverEnum direction);
		CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilder setCommodity(Commodity commodity);
		CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilder setPricingDates(CommodityPricingDates pricingDates);
		CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilder setAveragingMethod(AveragingMethodEnum averagingMethod);
		CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilder setId(String id);
		CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilder setFx(CommodityFx fx);
		CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilder setConversionFactor(BigDecimal conversionFactor);
		CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilder setCommodityNotionalQuantityModel(CommodityNotionalQuantityModel commodityNotionalQuantityModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("direction"), PayerReceiverEnum.class, getDirection(), this);
			processRosetta(path.newSubPath("commodity"), processor, Commodity.CommodityBuilder.class, getCommodity());
			processRosetta(path.newSubPath("pricingDates"), processor, CommodityPricingDates.CommodityPricingDatesBuilder.class, getPricingDates());
			processor.processBasic(path.newSubPath("averagingMethod"), AveragingMethodEnum.class, getAveragingMethod(), this);
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("fx"), processor, CommodityFx.CommodityFxBuilder.class, getFx());
			processor.processBasic(path.newSubPath("conversionFactor"), BigDecimal.class, getConversionFactor(), this);
			processRosetta(path.newSubPath("commodityNotionalQuantityModel"), processor, CommodityNotionalQuantityModel.CommodityNotionalQuantityModelBuilder.class, getCommodityNotionalQuantityModel());
		}
		

		CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityBasketUnderlyingByNotional  ***********************/
	class CommodityBasketUnderlyingByNotionalImpl extends CommodityBasketUnderlyingBase.CommodityBasketUnderlyingBaseImpl implements CommodityBasketUnderlyingByNotional {
		private final CommodityFx fx;
		private final BigDecimal conversionFactor;
		private final CommodityNotionalQuantityModel commodityNotionalQuantityModel;
		
		protected CommodityBasketUnderlyingByNotionalImpl(CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilder builder) {
			super(builder);
			this.fx = ofNullable(builder.getFx()).map(f->f.build()).orElse(null);
			this.conversionFactor = builder.getConversionFactor();
			this.commodityNotionalQuantityModel = ofNullable(builder.getCommodityNotionalQuantityModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("fx")
		public CommodityFx getFx() {
			return fx;
		}
		
		@Override
		@RosettaAttribute("conversionFactor")
		public BigDecimal getConversionFactor() {
			return conversionFactor;
		}
		
		@Override
		@RosettaAttribute("commodityNotionalQuantityModel")
		public CommodityNotionalQuantityModel getCommodityNotionalQuantityModel() {
			return commodityNotionalQuantityModel;
		}
		
		@Override
		public CommodityBasketUnderlyingByNotional build() {
			return this;
		}
		
		@Override
		public CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilder toBuilder() {
			CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getFx()).ifPresent(builder::setFx);
			ofNullable(getConversionFactor()).ifPresent(builder::setConversionFactor);
			ofNullable(getCommodityNotionalQuantityModel()).ifPresent(builder::setCommodityNotionalQuantityModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommodityBasketUnderlyingByNotional _that = getType().cast(o);
		
			if (!Objects.equals(fx, _that.getFx())) return false;
			if (!Objects.equals(conversionFactor, _that.getConversionFactor())) return false;
			if (!Objects.equals(commodityNotionalQuantityModel, _that.getCommodityNotionalQuantityModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (fx != null ? fx.hashCode() : 0);
			_result = 31 * _result + (conversionFactor != null ? conversionFactor.hashCode() : 0);
			_result = 31 * _result + (commodityNotionalQuantityModel != null ? commodityNotionalQuantityModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityBasketUnderlyingByNotional {" +
				"fx=" + this.fx + ", " +
				"conversionFactor=" + this.conversionFactor + ", " +
				"commodityNotionalQuantityModel=" + this.commodityNotionalQuantityModel +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CommodityBasketUnderlyingByNotional  ***********************/
	class CommodityBasketUnderlyingByNotionalBuilderImpl extends CommodityBasketUnderlyingBase.CommodityBasketUnderlyingBaseBuilderImpl  implements CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilder {
	
		protected CommodityFx.CommodityFxBuilder fx;
		protected BigDecimal conversionFactor;
		protected CommodityNotionalQuantityModel.CommodityNotionalQuantityModelBuilder commodityNotionalQuantityModel;
	
		public CommodityBasketUnderlyingByNotionalBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("fx")
		public CommodityFx.CommodityFxBuilder getFx() {
			return fx;
		}
		
		@Override
		public CommodityFx.CommodityFxBuilder getOrCreateFx() {
			CommodityFx.CommodityFxBuilder result;
			if (fx!=null) {
				result = fx;
			}
			else {
				result = fx = CommodityFx.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("conversionFactor")
		public BigDecimal getConversionFactor() {
			return conversionFactor;
		}
		
		@Override
		@RosettaAttribute("commodityNotionalQuantityModel")
		public CommodityNotionalQuantityModel.CommodityNotionalQuantityModelBuilder getCommodityNotionalQuantityModel() {
			return commodityNotionalQuantityModel;
		}
		
		@Override
		public CommodityNotionalQuantityModel.CommodityNotionalQuantityModelBuilder getOrCreateCommodityNotionalQuantityModel() {
			CommodityNotionalQuantityModel.CommodityNotionalQuantityModelBuilder result;
			if (commodityNotionalQuantityModel!=null) {
				result = commodityNotionalQuantityModel;
			}
			else {
				result = commodityNotionalQuantityModel = CommodityNotionalQuantityModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("direction")
		public CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilder setDirection(PayerReceiverEnum direction) {
			this.direction = direction==null?null:direction;
			return this;
		}
		@Override
		@RosettaAttribute("commodity")
		public CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilder setCommodity(Commodity commodity) {
			this.commodity = commodity==null?null:commodity.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("pricingDates")
		public CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilder setPricingDates(CommodityPricingDates pricingDates) {
			this.pricingDates = pricingDates==null?null:pricingDates.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("averagingMethod")
		public CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilder setAveragingMethod(AveragingMethodEnum averagingMethod) {
			this.averagingMethod = averagingMethod==null?null:averagingMethod;
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("fx")
		public CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilder setFx(CommodityFx fx) {
			this.fx = fx==null?null:fx.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("conversionFactor")
		public CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilder setConversionFactor(BigDecimal conversionFactor) {
			this.conversionFactor = conversionFactor==null?null:conversionFactor;
			return this;
		}
		@Override
		@RosettaAttribute("commodityNotionalQuantityModel")
		public CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilder setCommodityNotionalQuantityModel(CommodityNotionalQuantityModel commodityNotionalQuantityModel) {
			this.commodityNotionalQuantityModel = commodityNotionalQuantityModel==null?null:commodityNotionalQuantityModel.toBuilder();
			return this;
		}
		
		@Override
		public CommodityBasketUnderlyingByNotional build() {
			return new CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalImpl(this);
		}
		
		@Override
		public CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilder prune() {
			super.prune();
			if (fx!=null && !fx.prune().hasData()) fx = null;
			if (commodityNotionalQuantityModel!=null && !commodityNotionalQuantityModel.prune().hasData()) commodityNotionalQuantityModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getFx()!=null && getFx().hasData()) return true;
			if (getConversionFactor()!=null) return true;
			if (getCommodityNotionalQuantityModel()!=null && getCommodityNotionalQuantityModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilder o = (CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilder) other;
			
			merger.mergeRosetta(getFx(), o.getFx(), this::setFx);
			merger.mergeRosetta(getCommodityNotionalQuantityModel(), o.getCommodityNotionalQuantityModel(), this::setCommodityNotionalQuantityModel);
			
			merger.mergeBasic(getConversionFactor(), o.getConversionFactor(), this::setConversionFactor);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommodityBasketUnderlyingByNotional _that = getType().cast(o);
		
			if (!Objects.equals(fx, _that.getFx())) return false;
			if (!Objects.equals(conversionFactor, _that.getConversionFactor())) return false;
			if (!Objects.equals(commodityNotionalQuantityModel, _that.getCommodityNotionalQuantityModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (fx != null ? fx.hashCode() : 0);
			_result = 31 * _result + (conversionFactor != null ? conversionFactor.hashCode() : 0);
			_result = 31 * _result + (commodityNotionalQuantityModel != null ? commodityNotionalQuantityModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityBasketUnderlyingByNotionalBuilder {" +
				"fx=" + this.fx + ", " +
				"conversionFactor=" + this.conversionFactor + ", " +
				"commodityNotionalQuantityModel=" + this.commodityNotionalQuantityModel +
			'}' + " " + super.toString();
		}
	}
}
