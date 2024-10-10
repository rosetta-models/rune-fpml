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
import fpml.confirmation.CommodityTrigger;
import fpml.confirmation.CommodityTrigger.CommodityTriggerBuilder;
import fpml.confirmation.CommodityTrigger.CommodityTriggerBuilderImpl;
import fpml.confirmation.CommodityTrigger.CommodityTriggerImpl;
import fpml.confirmation.CommodityTriggerSequence;
import fpml.confirmation.FixedPrice;
import fpml.confirmation.TriggerTypeEnum;
import fpml.confirmation.meta.CommodityTriggerMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The barrier which, when breached, triggers the knock-in or knock-out of the barrier option.
 * @version ${project.version}
 */
@RosettaDataType(value="CommodityTrigger", builder=CommodityTrigger.CommodityTriggerBuilderImpl.class, version="${project.version}")
public interface CommodityTrigger extends RosettaModelObject {

	CommodityTriggerMeta metaData = new CommodityTriggerMeta();

	/*********************** Getter Methods  ***********************/
	CommodityTriggerSequence getCommodityTriggerSequence();
	/**
	 * A barrier expressed as a percentage of notional quantity or commodity price level.
	 */
	BigDecimal getLevelPercentage();
	/**
	 * A barrier expressed as a price level.
	 */
	FixedPrice getLevelPrice();
	/**
	 * For barrier options: the specification of how an option will trigger or expire based on the position of the spot rate relative to the trigger level. For trades with selectable notionals: the specification of the conditions where one of the alternative notional values would apply.
	 */
	TriggerTypeEnum getTriggerType();

	/*********************** Build Methods  ***********************/
	CommodityTrigger build();
	
	CommodityTrigger.CommodityTriggerBuilder toBuilder();
	
	static CommodityTrigger.CommodityTriggerBuilder builder() {
		return new CommodityTrigger.CommodityTriggerBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityTrigger> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityTrigger> getType() {
		return CommodityTrigger.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("commodityTriggerSequence"), processor, CommodityTriggerSequence.class, getCommodityTriggerSequence());
		processor.processBasic(path.newSubPath("levelPercentage"), BigDecimal.class, getLevelPercentage(), this);
		processRosetta(path.newSubPath("levelPrice"), processor, FixedPrice.class, getLevelPrice());
		processor.processBasic(path.newSubPath("triggerType"), TriggerTypeEnum.class, getTriggerType(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityTriggerBuilder extends CommodityTrigger, RosettaModelObjectBuilder {
		CommodityTriggerSequence.CommodityTriggerSequenceBuilder getOrCreateCommodityTriggerSequence();
		CommodityTriggerSequence.CommodityTriggerSequenceBuilder getCommodityTriggerSequence();
		FixedPrice.FixedPriceBuilder getOrCreateLevelPrice();
		FixedPrice.FixedPriceBuilder getLevelPrice();
		CommodityTrigger.CommodityTriggerBuilder setCommodityTriggerSequence(CommodityTriggerSequence commodityTriggerSequence);
		CommodityTrigger.CommodityTriggerBuilder setLevelPercentage(BigDecimal levelPercentage);
		CommodityTrigger.CommodityTriggerBuilder setLevelPrice(FixedPrice levelPrice);
		CommodityTrigger.CommodityTriggerBuilder setTriggerType(TriggerTypeEnum triggerType);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("commodityTriggerSequence"), processor, CommodityTriggerSequence.CommodityTriggerSequenceBuilder.class, getCommodityTriggerSequence());
			processor.processBasic(path.newSubPath("levelPercentage"), BigDecimal.class, getLevelPercentage(), this);
			processRosetta(path.newSubPath("levelPrice"), processor, FixedPrice.FixedPriceBuilder.class, getLevelPrice());
			processor.processBasic(path.newSubPath("triggerType"), TriggerTypeEnum.class, getTriggerType(), this);
		}
		

		CommodityTrigger.CommodityTriggerBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityTrigger  ***********************/
	class CommodityTriggerImpl implements CommodityTrigger {
		private final CommodityTriggerSequence commodityTriggerSequence;
		private final BigDecimal levelPercentage;
		private final FixedPrice levelPrice;
		private final TriggerTypeEnum triggerType;
		
		protected CommodityTriggerImpl(CommodityTrigger.CommodityTriggerBuilder builder) {
			this.commodityTriggerSequence = ofNullable(builder.getCommodityTriggerSequence()).map(f->f.build()).orElse(null);
			this.levelPercentage = builder.getLevelPercentage();
			this.levelPrice = ofNullable(builder.getLevelPrice()).map(f->f.build()).orElse(null);
			this.triggerType = builder.getTriggerType();
		}
		
		@Override
		@RosettaAttribute("commodityTriggerSequence")
		public CommodityTriggerSequence getCommodityTriggerSequence() {
			return commodityTriggerSequence;
		}
		
		@Override
		@RosettaAttribute("levelPercentage")
		public BigDecimal getLevelPercentage() {
			return levelPercentage;
		}
		
		@Override
		@RosettaAttribute("levelPrice")
		public FixedPrice getLevelPrice() {
			return levelPrice;
		}
		
		@Override
		@RosettaAttribute("triggerType")
		public TriggerTypeEnum getTriggerType() {
			return triggerType;
		}
		
		@Override
		public CommodityTrigger build() {
			return this;
		}
		
		@Override
		public CommodityTrigger.CommodityTriggerBuilder toBuilder() {
			CommodityTrigger.CommodityTriggerBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityTrigger.CommodityTriggerBuilder builder) {
			ofNullable(getCommodityTriggerSequence()).ifPresent(builder::setCommodityTriggerSequence);
			ofNullable(getLevelPercentage()).ifPresent(builder::setLevelPercentage);
			ofNullable(getLevelPrice()).ifPresent(builder::setLevelPrice);
			ofNullable(getTriggerType()).ifPresent(builder::setTriggerType);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityTrigger _that = getType().cast(o);
		
			if (!Objects.equals(commodityTriggerSequence, _that.getCommodityTriggerSequence())) return false;
			if (!Objects.equals(levelPercentage, _that.getLevelPercentage())) return false;
			if (!Objects.equals(levelPrice, _that.getLevelPrice())) return false;
			if (!Objects.equals(triggerType, _that.getTriggerType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (commodityTriggerSequence != null ? commodityTriggerSequence.hashCode() : 0);
			_result = 31 * _result + (levelPercentage != null ? levelPercentage.hashCode() : 0);
			_result = 31 * _result + (levelPrice != null ? levelPrice.hashCode() : 0);
			_result = 31 * _result + (triggerType != null ? triggerType.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityTrigger {" +
				"commodityTriggerSequence=" + this.commodityTriggerSequence + ", " +
				"levelPercentage=" + this.levelPercentage + ", " +
				"levelPrice=" + this.levelPrice + ", " +
				"triggerType=" + this.triggerType +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityTrigger  ***********************/
	class CommodityTriggerBuilderImpl implements CommodityTrigger.CommodityTriggerBuilder {
	
		protected CommodityTriggerSequence.CommodityTriggerSequenceBuilder commodityTriggerSequence;
		protected BigDecimal levelPercentage;
		protected FixedPrice.FixedPriceBuilder levelPrice;
		protected TriggerTypeEnum triggerType;
	
		public CommodityTriggerBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("commodityTriggerSequence")
		public CommodityTriggerSequence.CommodityTriggerSequenceBuilder getCommodityTriggerSequence() {
			return commodityTriggerSequence;
		}
		
		@Override
		public CommodityTriggerSequence.CommodityTriggerSequenceBuilder getOrCreateCommodityTriggerSequence() {
			CommodityTriggerSequence.CommodityTriggerSequenceBuilder result;
			if (commodityTriggerSequence!=null) {
				result = commodityTriggerSequence;
			}
			else {
				result = commodityTriggerSequence = CommodityTriggerSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("levelPercentage")
		public BigDecimal getLevelPercentage() {
			return levelPercentage;
		}
		
		@Override
		@RosettaAttribute("levelPrice")
		public FixedPrice.FixedPriceBuilder getLevelPrice() {
			return levelPrice;
		}
		
		@Override
		public FixedPrice.FixedPriceBuilder getOrCreateLevelPrice() {
			FixedPrice.FixedPriceBuilder result;
			if (levelPrice!=null) {
				result = levelPrice;
			}
			else {
				result = levelPrice = FixedPrice.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("triggerType")
		public TriggerTypeEnum getTriggerType() {
			return triggerType;
		}
		
		@Override
		@RosettaAttribute("commodityTriggerSequence")
		public CommodityTrigger.CommodityTriggerBuilder setCommodityTriggerSequence(CommodityTriggerSequence commodityTriggerSequence) {
			this.commodityTriggerSequence = commodityTriggerSequence==null?null:commodityTriggerSequence.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("levelPercentage")
		public CommodityTrigger.CommodityTriggerBuilder setLevelPercentage(BigDecimal levelPercentage) {
			this.levelPercentage = levelPercentage==null?null:levelPercentage;
			return this;
		}
		@Override
		@RosettaAttribute("levelPrice")
		public CommodityTrigger.CommodityTriggerBuilder setLevelPrice(FixedPrice levelPrice) {
			this.levelPrice = levelPrice==null?null:levelPrice.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("triggerType")
		public CommodityTrigger.CommodityTriggerBuilder setTriggerType(TriggerTypeEnum triggerType) {
			this.triggerType = triggerType==null?null:triggerType;
			return this;
		}
		
		@Override
		public CommodityTrigger build() {
			return new CommodityTrigger.CommodityTriggerImpl(this);
		}
		
		@Override
		public CommodityTrigger.CommodityTriggerBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityTrigger.CommodityTriggerBuilder prune() {
			if (commodityTriggerSequence!=null && !commodityTriggerSequence.prune().hasData()) commodityTriggerSequence = null;
			if (levelPrice!=null && !levelPrice.prune().hasData()) levelPrice = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCommodityTriggerSequence()!=null && getCommodityTriggerSequence().hasData()) return true;
			if (getLevelPercentage()!=null) return true;
			if (getLevelPrice()!=null && getLevelPrice().hasData()) return true;
			if (getTriggerType()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityTrigger.CommodityTriggerBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityTrigger.CommodityTriggerBuilder o = (CommodityTrigger.CommodityTriggerBuilder) other;
			
			merger.mergeRosetta(getCommodityTriggerSequence(), o.getCommodityTriggerSequence(), this::setCommodityTriggerSequence);
			merger.mergeRosetta(getLevelPrice(), o.getLevelPrice(), this::setLevelPrice);
			
			merger.mergeBasic(getLevelPercentage(), o.getLevelPercentage(), this::setLevelPercentage);
			merger.mergeBasic(getTriggerType(), o.getTriggerType(), this::setTriggerType);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityTrigger _that = getType().cast(o);
		
			if (!Objects.equals(commodityTriggerSequence, _that.getCommodityTriggerSequence())) return false;
			if (!Objects.equals(levelPercentage, _that.getLevelPercentage())) return false;
			if (!Objects.equals(levelPrice, _that.getLevelPrice())) return false;
			if (!Objects.equals(triggerType, _that.getTriggerType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (commodityTriggerSequence != null ? commodityTriggerSequence.hashCode() : 0);
			_result = 31 * _result + (levelPercentage != null ? levelPercentage.hashCode() : 0);
			_result = 31 * _result + (levelPrice != null ? levelPrice.hashCode() : 0);
			_result = 31 * _result + (triggerType != null ? triggerType.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityTriggerBuilder {" +
				"commodityTriggerSequence=" + this.commodityTriggerSequence + ", " +
				"levelPercentage=" + this.levelPercentage + ", " +
				"levelPrice=" + this.levelPrice + ", " +
				"triggerType=" + this.triggerType +
			'}';
		}
	}
}
