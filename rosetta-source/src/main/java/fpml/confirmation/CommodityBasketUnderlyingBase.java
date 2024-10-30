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
import fpml.confirmation.CommodityPricingDates;
import fpml.confirmation.PayerReceiverEnum;
import fpml.confirmation.meta.CommodityBasketUnderlyingBaseMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="CommodityBasketUnderlyingBase", builder=CommodityBasketUnderlyingBase.CommodityBasketUnderlyingBaseBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface CommodityBasketUnderlyingBase extends RosettaModelObject {

	CommodityBasketUnderlyingBaseMeta metaData = new CommodityBasketUnderlyingBaseMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Indicates the role of the option buyer with regard to this underlyer.
	 */
	PayerReceiverEnum getDirection();
	/**
	 * Specifies the underlying component. At the time of the initial schema design, only underlyers of type Commodity are supported; the choice group in the future could offer the possibility of adding other types later.
	 */
	Commodity getCommodity();
	/**
	 * The dates on which the option will price.
	 */
	CommodityPricingDates getPricingDates();
	/**
	 * The Method of Averaging if there is more than one Pricing Date.
	 */
	AveragingMethodEnum getAveragingMethod();
	String getId();

	/*********************** Build Methods  ***********************/
	CommodityBasketUnderlyingBase build();
	
	CommodityBasketUnderlyingBase.CommodityBasketUnderlyingBaseBuilder toBuilder();
	
	static CommodityBasketUnderlyingBase.CommodityBasketUnderlyingBaseBuilder builder() {
		return new CommodityBasketUnderlyingBase.CommodityBasketUnderlyingBaseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityBasketUnderlyingBase> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityBasketUnderlyingBase> getType() {
		return CommodityBasketUnderlyingBase.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("direction"), PayerReceiverEnum.class, getDirection(), this);
		processRosetta(path.newSubPath("commodity"), processor, Commodity.class, getCommodity());
		processRosetta(path.newSubPath("pricingDates"), processor, CommodityPricingDates.class, getPricingDates());
		processor.processBasic(path.newSubPath("averagingMethod"), AveragingMethodEnum.class, getAveragingMethod(), this);
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityBasketUnderlyingBaseBuilder extends CommodityBasketUnderlyingBase, RosettaModelObjectBuilder {
		Commodity.CommodityBuilder getOrCreateCommodity();
		Commodity.CommodityBuilder getCommodity();
		CommodityPricingDates.CommodityPricingDatesBuilder getOrCreatePricingDates();
		CommodityPricingDates.CommodityPricingDatesBuilder getPricingDates();
		CommodityBasketUnderlyingBase.CommodityBasketUnderlyingBaseBuilder setDirection(PayerReceiverEnum direction);
		CommodityBasketUnderlyingBase.CommodityBasketUnderlyingBaseBuilder setCommodity(Commodity commodity);
		CommodityBasketUnderlyingBase.CommodityBasketUnderlyingBaseBuilder setPricingDates(CommodityPricingDates pricingDates);
		CommodityBasketUnderlyingBase.CommodityBasketUnderlyingBaseBuilder setAveragingMethod(AveragingMethodEnum averagingMethod);
		CommodityBasketUnderlyingBase.CommodityBasketUnderlyingBaseBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("direction"), PayerReceiverEnum.class, getDirection(), this);
			processRosetta(path.newSubPath("commodity"), processor, Commodity.CommodityBuilder.class, getCommodity());
			processRosetta(path.newSubPath("pricingDates"), processor, CommodityPricingDates.CommodityPricingDatesBuilder.class, getPricingDates());
			processor.processBasic(path.newSubPath("averagingMethod"), AveragingMethodEnum.class, getAveragingMethod(), this);
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		CommodityBasketUnderlyingBase.CommodityBasketUnderlyingBaseBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityBasketUnderlyingBase  ***********************/
	class CommodityBasketUnderlyingBaseImpl implements CommodityBasketUnderlyingBase {
		private final PayerReceiverEnum direction;
		private final Commodity commodity;
		private final CommodityPricingDates pricingDates;
		private final AveragingMethodEnum averagingMethod;
		private final String id;
		
		protected CommodityBasketUnderlyingBaseImpl(CommodityBasketUnderlyingBase.CommodityBasketUnderlyingBaseBuilder builder) {
			this.direction = builder.getDirection();
			this.commodity = ofNullable(builder.getCommodity()).map(f->f.build()).orElse(null);
			this.pricingDates = ofNullable(builder.getPricingDates()).map(f->f.build()).orElse(null);
			this.averagingMethod = builder.getAveragingMethod();
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("direction")
		public PayerReceiverEnum getDirection() {
			return direction;
		}
		
		@Override
		@RosettaAttribute("commodity")
		public Commodity getCommodity() {
			return commodity;
		}
		
		@Override
		@RosettaAttribute("pricingDates")
		public CommodityPricingDates getPricingDates() {
			return pricingDates;
		}
		
		@Override
		@RosettaAttribute("averagingMethod")
		public AveragingMethodEnum getAveragingMethod() {
			return averagingMethod;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public CommodityBasketUnderlyingBase build() {
			return this;
		}
		
		@Override
		public CommodityBasketUnderlyingBase.CommodityBasketUnderlyingBaseBuilder toBuilder() {
			CommodityBasketUnderlyingBase.CommodityBasketUnderlyingBaseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityBasketUnderlyingBase.CommodityBasketUnderlyingBaseBuilder builder) {
			ofNullable(getDirection()).ifPresent(builder::setDirection);
			ofNullable(getCommodity()).ifPresent(builder::setCommodity);
			ofNullable(getPricingDates()).ifPresent(builder::setPricingDates);
			ofNullable(getAveragingMethod()).ifPresent(builder::setAveragingMethod);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityBasketUnderlyingBase _that = getType().cast(o);
		
			if (!Objects.equals(direction, _that.getDirection())) return false;
			if (!Objects.equals(commodity, _that.getCommodity())) return false;
			if (!Objects.equals(pricingDates, _that.getPricingDates())) return false;
			if (!Objects.equals(averagingMethod, _that.getAveragingMethod())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (direction != null ? direction.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (commodity != null ? commodity.hashCode() : 0);
			_result = 31 * _result + (pricingDates != null ? pricingDates.hashCode() : 0);
			_result = 31 * _result + (averagingMethod != null ? averagingMethod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityBasketUnderlyingBase {" +
				"direction=" + this.direction + ", " +
				"commodity=" + this.commodity + ", " +
				"pricingDates=" + this.pricingDates + ", " +
				"averagingMethod=" + this.averagingMethod + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityBasketUnderlyingBase  ***********************/
	class CommodityBasketUnderlyingBaseBuilderImpl implements CommodityBasketUnderlyingBase.CommodityBasketUnderlyingBaseBuilder {
	
		protected PayerReceiverEnum direction;
		protected Commodity.CommodityBuilder commodity;
		protected CommodityPricingDates.CommodityPricingDatesBuilder pricingDates;
		protected AveragingMethodEnum averagingMethod;
		protected String id;
	
		public CommodityBasketUnderlyingBaseBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("direction")
		public PayerReceiverEnum getDirection() {
			return direction;
		}
		
		@Override
		@RosettaAttribute("commodity")
		public Commodity.CommodityBuilder getCommodity() {
			return commodity;
		}
		
		@Override
		public Commodity.CommodityBuilder getOrCreateCommodity() {
			Commodity.CommodityBuilder result;
			if (commodity!=null) {
				result = commodity;
			}
			else {
				result = commodity = Commodity.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("pricingDates")
		public CommodityPricingDates.CommodityPricingDatesBuilder getPricingDates() {
			return pricingDates;
		}
		
		@Override
		public CommodityPricingDates.CommodityPricingDatesBuilder getOrCreatePricingDates() {
			CommodityPricingDates.CommodityPricingDatesBuilder result;
			if (pricingDates!=null) {
				result = pricingDates;
			}
			else {
				result = pricingDates = CommodityPricingDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("averagingMethod")
		public AveragingMethodEnum getAveragingMethod() {
			return averagingMethod;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("direction")
		public CommodityBasketUnderlyingBase.CommodityBasketUnderlyingBaseBuilder setDirection(PayerReceiverEnum direction) {
			this.direction = direction==null?null:direction;
			return this;
		}
		@Override
		@RosettaAttribute("commodity")
		public CommodityBasketUnderlyingBase.CommodityBasketUnderlyingBaseBuilder setCommodity(Commodity commodity) {
			this.commodity = commodity==null?null:commodity.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("pricingDates")
		public CommodityBasketUnderlyingBase.CommodityBasketUnderlyingBaseBuilder setPricingDates(CommodityPricingDates pricingDates) {
			this.pricingDates = pricingDates==null?null:pricingDates.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("averagingMethod")
		public CommodityBasketUnderlyingBase.CommodityBasketUnderlyingBaseBuilder setAveragingMethod(AveragingMethodEnum averagingMethod) {
			this.averagingMethod = averagingMethod==null?null:averagingMethod;
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public CommodityBasketUnderlyingBase.CommodityBasketUnderlyingBaseBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public CommodityBasketUnderlyingBase build() {
			return new CommodityBasketUnderlyingBase.CommodityBasketUnderlyingBaseImpl(this);
		}
		
		@Override
		public CommodityBasketUnderlyingBase.CommodityBasketUnderlyingBaseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityBasketUnderlyingBase.CommodityBasketUnderlyingBaseBuilder prune() {
			if (commodity!=null && !commodity.prune().hasData()) commodity = null;
			if (pricingDates!=null && !pricingDates.prune().hasData()) pricingDates = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDirection()!=null) return true;
			if (getCommodity()!=null && getCommodity().hasData()) return true;
			if (getPricingDates()!=null && getPricingDates().hasData()) return true;
			if (getAveragingMethod()!=null) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityBasketUnderlyingBase.CommodityBasketUnderlyingBaseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityBasketUnderlyingBase.CommodityBasketUnderlyingBaseBuilder o = (CommodityBasketUnderlyingBase.CommodityBasketUnderlyingBaseBuilder) other;
			
			merger.mergeRosetta(getCommodity(), o.getCommodity(), this::setCommodity);
			merger.mergeRosetta(getPricingDates(), o.getPricingDates(), this::setPricingDates);
			
			merger.mergeBasic(getDirection(), o.getDirection(), this::setDirection);
			merger.mergeBasic(getAveragingMethod(), o.getAveragingMethod(), this::setAveragingMethod);
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityBasketUnderlyingBase _that = getType().cast(o);
		
			if (!Objects.equals(direction, _that.getDirection())) return false;
			if (!Objects.equals(commodity, _that.getCommodity())) return false;
			if (!Objects.equals(pricingDates, _that.getPricingDates())) return false;
			if (!Objects.equals(averagingMethod, _that.getAveragingMethod())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (direction != null ? direction.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (commodity != null ? commodity.hashCode() : 0);
			_result = 31 * _result + (pricingDates != null ? pricingDates.hashCode() : 0);
			_result = 31 * _result + (averagingMethod != null ? averagingMethod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityBasketUnderlyingBaseBuilder {" +
				"direction=" + this.direction + ", " +
				"commodity=" + this.commodity + ", " +
				"pricingDates=" + this.pricingDates + ", " +
				"averagingMethod=" + this.averagingMethod + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
