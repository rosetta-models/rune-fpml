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
import fpml.confirmation.FxBusinessCenterDateTime;
import fpml.confirmation.FxTouch;
import fpml.confirmation.FxTouch.FxTouchBuilder;
import fpml.confirmation.FxTouch.FxTouchBuilderImpl;
import fpml.confirmation.FxTouch.FxTouchImpl;
import fpml.confirmation.FxTouchSequence;
import fpml.confirmation.InformationSource;
import fpml.confirmation.QuotedCurrencyPair;
import fpml.confirmation.TouchConditionEnum;
import fpml.confirmation.TriggerConditionEnum;
import fpml.confirmation.meta.FxTouchMeta;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Describes an american or discrete touch or no-touch trigger applied to an FX binary or digital option.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="FxTouch", builder=FxTouch.FxTouchBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface FxTouch extends RosettaModelObject {

	FxTouchMeta metaData = new FxTouchMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * This specifies whether the applied trigger is a touch or no touch type.
	 */
	TouchConditionEnum getTouchCondition();
	/**
	 * This specifies whether the trigger direction is &quot;AtOrAbove&quot; or &quot;AtOrBelow; that is, that a barrier event occurs if the spot rate is at or above the trigger rate, or at or below the trigger rate during the period of observation of an american trigger, or at the times of observation of a discrete trigger. DEPRECATE: Values &quot;Above&quot; and &quot;Below&quot; are deprecated.
	 */
	TriggerConditionEnum getDirection();
	/**
	 * Defines the two currencies for an FX trade and the quotation relationship between the two currencies.
	 */
	QuotedCurrencyPair getQuotedCurrencyPair();
	/**
	 * The market rate is observed relative to the trigger rate, and if it is found to be on the predefined side of (above or below) the trigger rate, a barrier event is deemed to have occurred.
	 */
	BigDecimal getTriggerRate();
	/**
	 * An optional element used for FX forwards and certain types of FX OTC options. For deals consumated in the FX Forwards Market, this represents the current market rate for a particular currency pair. For barrier and digital/binary options, it can be useful to include the spot rate at the time the option was executed to make it easier to know whether the market rate needs to move &quot;up&quot; or &quot;down&quot; to trigger a barrier event.
	 */
	BigDecimal getSpotRate();
	/**
	 * The information source where a published or displayed market rate will be obtained, e.g. Telerate Page 3750.
	 */
	List<? extends InformationSource> getInformationSource();
	FxTouchSequence getFxTouchSequence();
	/**
	 * The dates and times at which rate observations are made to determine whether a barrier event has occurred for a discrete trigger. If the time is not present then the time is deemed to be the same as the expiration time.
	 */
	List<? extends FxBusinessCenterDateTime> getObservationPoint();

	/*********************** Build Methods  ***********************/
	FxTouch build();
	
	FxTouch.FxTouchBuilder toBuilder();
	
	static FxTouch.FxTouchBuilder builder() {
		return new FxTouch.FxTouchBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxTouch> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxTouch> getType() {
		return FxTouch.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("touchCondition"), TouchConditionEnum.class, getTouchCondition(), this);
		processor.processBasic(path.newSubPath("direction"), TriggerConditionEnum.class, getDirection(), this);
		processRosetta(path.newSubPath("quotedCurrencyPair"), processor, QuotedCurrencyPair.class, getQuotedCurrencyPair());
		processor.processBasic(path.newSubPath("triggerRate"), BigDecimal.class, getTriggerRate(), this);
		processor.processBasic(path.newSubPath("spotRate"), BigDecimal.class, getSpotRate(), this);
		processRosetta(path.newSubPath("informationSource"), processor, InformationSource.class, getInformationSource());
		processRosetta(path.newSubPath("fxTouchSequence"), processor, FxTouchSequence.class, getFxTouchSequence());
		processRosetta(path.newSubPath("observationPoint"), processor, FxBusinessCenterDateTime.class, getObservationPoint());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxTouchBuilder extends FxTouch, RosettaModelObjectBuilder {
		QuotedCurrencyPair.QuotedCurrencyPairBuilder getOrCreateQuotedCurrencyPair();
		QuotedCurrencyPair.QuotedCurrencyPairBuilder getQuotedCurrencyPair();
		InformationSource.InformationSourceBuilder getOrCreateInformationSource(int _index);
		List<? extends InformationSource.InformationSourceBuilder> getInformationSource();
		FxTouchSequence.FxTouchSequenceBuilder getOrCreateFxTouchSequence();
		FxTouchSequence.FxTouchSequenceBuilder getFxTouchSequence();
		FxBusinessCenterDateTime.FxBusinessCenterDateTimeBuilder getOrCreateObservationPoint(int _index);
		List<? extends FxBusinessCenterDateTime.FxBusinessCenterDateTimeBuilder> getObservationPoint();
		FxTouch.FxTouchBuilder setTouchCondition(TouchConditionEnum touchCondition);
		FxTouch.FxTouchBuilder setDirection(TriggerConditionEnum direction);
		FxTouch.FxTouchBuilder setQuotedCurrencyPair(QuotedCurrencyPair quotedCurrencyPair);
		FxTouch.FxTouchBuilder setTriggerRate(BigDecimal triggerRate);
		FxTouch.FxTouchBuilder setSpotRate(BigDecimal spotRate);
		FxTouch.FxTouchBuilder addInformationSource(InformationSource informationSource0);
		FxTouch.FxTouchBuilder addInformationSource(InformationSource informationSource1, int _idx);
		FxTouch.FxTouchBuilder addInformationSource(List<? extends InformationSource> informationSource2);
		FxTouch.FxTouchBuilder setInformationSource(List<? extends InformationSource> informationSource3);
		FxTouch.FxTouchBuilder setFxTouchSequence(FxTouchSequence fxTouchSequence);
		FxTouch.FxTouchBuilder addObservationPoint(FxBusinessCenterDateTime observationPoint0);
		FxTouch.FxTouchBuilder addObservationPoint(FxBusinessCenterDateTime observationPoint1, int _idx);
		FxTouch.FxTouchBuilder addObservationPoint(List<? extends FxBusinessCenterDateTime> observationPoint2);
		FxTouch.FxTouchBuilder setObservationPoint(List<? extends FxBusinessCenterDateTime> observationPoint3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("touchCondition"), TouchConditionEnum.class, getTouchCondition(), this);
			processor.processBasic(path.newSubPath("direction"), TriggerConditionEnum.class, getDirection(), this);
			processRosetta(path.newSubPath("quotedCurrencyPair"), processor, QuotedCurrencyPair.QuotedCurrencyPairBuilder.class, getQuotedCurrencyPair());
			processor.processBasic(path.newSubPath("triggerRate"), BigDecimal.class, getTriggerRate(), this);
			processor.processBasic(path.newSubPath("spotRate"), BigDecimal.class, getSpotRate(), this);
			processRosetta(path.newSubPath("informationSource"), processor, InformationSource.InformationSourceBuilder.class, getInformationSource());
			processRosetta(path.newSubPath("fxTouchSequence"), processor, FxTouchSequence.FxTouchSequenceBuilder.class, getFxTouchSequence());
			processRosetta(path.newSubPath("observationPoint"), processor, FxBusinessCenterDateTime.FxBusinessCenterDateTimeBuilder.class, getObservationPoint());
		}
		

		FxTouch.FxTouchBuilder prune();
	}

	/*********************** Immutable Implementation of FxTouch  ***********************/
	class FxTouchImpl implements FxTouch {
		private final TouchConditionEnum touchCondition;
		private final TriggerConditionEnum direction;
		private final QuotedCurrencyPair quotedCurrencyPair;
		private final BigDecimal triggerRate;
		private final BigDecimal spotRate;
		private final List<? extends InformationSource> informationSource;
		private final FxTouchSequence fxTouchSequence;
		private final List<? extends FxBusinessCenterDateTime> observationPoint;
		
		protected FxTouchImpl(FxTouch.FxTouchBuilder builder) {
			this.touchCondition = builder.getTouchCondition();
			this.direction = builder.getDirection();
			this.quotedCurrencyPair = ofNullable(builder.getQuotedCurrencyPair()).map(f->f.build()).orElse(null);
			this.triggerRate = builder.getTriggerRate();
			this.spotRate = builder.getSpotRate();
			this.informationSource = ofNullable(builder.getInformationSource()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.fxTouchSequence = ofNullable(builder.getFxTouchSequence()).map(f->f.build()).orElse(null);
			this.observationPoint = ofNullable(builder.getObservationPoint()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("touchCondition")
		public TouchConditionEnum getTouchCondition() {
			return touchCondition;
		}
		
		@Override
		@RosettaAttribute("direction")
		public TriggerConditionEnum getDirection() {
			return direction;
		}
		
		@Override
		@RosettaAttribute("quotedCurrencyPair")
		public QuotedCurrencyPair getQuotedCurrencyPair() {
			return quotedCurrencyPair;
		}
		
		@Override
		@RosettaAttribute("triggerRate")
		public BigDecimal getTriggerRate() {
			return triggerRate;
		}
		
		@Override
		@RosettaAttribute("spotRate")
		public BigDecimal getSpotRate() {
			return spotRate;
		}
		
		@Override
		@RosettaAttribute("informationSource")
		public List<? extends InformationSource> getInformationSource() {
			return informationSource;
		}
		
		@Override
		@RosettaAttribute("fxTouchSequence")
		public FxTouchSequence getFxTouchSequence() {
			return fxTouchSequence;
		}
		
		@Override
		@RosettaAttribute("observationPoint")
		public List<? extends FxBusinessCenterDateTime> getObservationPoint() {
			return observationPoint;
		}
		
		@Override
		public FxTouch build() {
			return this;
		}
		
		@Override
		public FxTouch.FxTouchBuilder toBuilder() {
			FxTouch.FxTouchBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxTouch.FxTouchBuilder builder) {
			ofNullable(getTouchCondition()).ifPresent(builder::setTouchCondition);
			ofNullable(getDirection()).ifPresent(builder::setDirection);
			ofNullable(getQuotedCurrencyPair()).ifPresent(builder::setQuotedCurrencyPair);
			ofNullable(getTriggerRate()).ifPresent(builder::setTriggerRate);
			ofNullable(getSpotRate()).ifPresent(builder::setSpotRate);
			ofNullable(getInformationSource()).ifPresent(builder::setInformationSource);
			ofNullable(getFxTouchSequence()).ifPresent(builder::setFxTouchSequence);
			ofNullable(getObservationPoint()).ifPresent(builder::setObservationPoint);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxTouch _that = getType().cast(o);
		
			if (!Objects.equals(touchCondition, _that.getTouchCondition())) return false;
			if (!Objects.equals(direction, _that.getDirection())) return false;
			if (!Objects.equals(quotedCurrencyPair, _that.getQuotedCurrencyPair())) return false;
			if (!Objects.equals(triggerRate, _that.getTriggerRate())) return false;
			if (!Objects.equals(spotRate, _that.getSpotRate())) return false;
			if (!ListEquals.listEquals(informationSource, _that.getInformationSource())) return false;
			if (!Objects.equals(fxTouchSequence, _that.getFxTouchSequence())) return false;
			if (!ListEquals.listEquals(observationPoint, _that.getObservationPoint())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (touchCondition != null ? touchCondition.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (direction != null ? direction.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (quotedCurrencyPair != null ? quotedCurrencyPair.hashCode() : 0);
			_result = 31 * _result + (triggerRate != null ? triggerRate.hashCode() : 0);
			_result = 31 * _result + (spotRate != null ? spotRate.hashCode() : 0);
			_result = 31 * _result + (informationSource != null ? informationSource.hashCode() : 0);
			_result = 31 * _result + (fxTouchSequence != null ? fxTouchSequence.hashCode() : 0);
			_result = 31 * _result + (observationPoint != null ? observationPoint.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxTouch {" +
				"touchCondition=" + this.touchCondition + ", " +
				"direction=" + this.direction + ", " +
				"quotedCurrencyPair=" + this.quotedCurrencyPair + ", " +
				"triggerRate=" + this.triggerRate + ", " +
				"spotRate=" + this.spotRate + ", " +
				"informationSource=" + this.informationSource + ", " +
				"fxTouchSequence=" + this.fxTouchSequence + ", " +
				"observationPoint=" + this.observationPoint +
			'}';
		}
	}

	/*********************** Builder Implementation of FxTouch  ***********************/
	class FxTouchBuilderImpl implements FxTouch.FxTouchBuilder {
	
		protected TouchConditionEnum touchCondition;
		protected TriggerConditionEnum direction;
		protected QuotedCurrencyPair.QuotedCurrencyPairBuilder quotedCurrencyPair;
		protected BigDecimal triggerRate;
		protected BigDecimal spotRate;
		protected List<InformationSource.InformationSourceBuilder> informationSource = new ArrayList<>();
		protected FxTouchSequence.FxTouchSequenceBuilder fxTouchSequence;
		protected List<FxBusinessCenterDateTime.FxBusinessCenterDateTimeBuilder> observationPoint = new ArrayList<>();
	
		public FxTouchBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("touchCondition")
		public TouchConditionEnum getTouchCondition() {
			return touchCondition;
		}
		
		@Override
		@RosettaAttribute("direction")
		public TriggerConditionEnum getDirection() {
			return direction;
		}
		
		@Override
		@RosettaAttribute("quotedCurrencyPair")
		public QuotedCurrencyPair.QuotedCurrencyPairBuilder getQuotedCurrencyPair() {
			return quotedCurrencyPair;
		}
		
		@Override
		public QuotedCurrencyPair.QuotedCurrencyPairBuilder getOrCreateQuotedCurrencyPair() {
			QuotedCurrencyPair.QuotedCurrencyPairBuilder result;
			if (quotedCurrencyPair!=null) {
				result = quotedCurrencyPair;
			}
			else {
				result = quotedCurrencyPair = QuotedCurrencyPair.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("triggerRate")
		public BigDecimal getTriggerRate() {
			return triggerRate;
		}
		
		@Override
		@RosettaAttribute("spotRate")
		public BigDecimal getSpotRate() {
			return spotRate;
		}
		
		@Override
		@RosettaAttribute("informationSource")
		public List<? extends InformationSource.InformationSourceBuilder> getInformationSource() {
			return informationSource;
		}
		
		@Override
		public InformationSource.InformationSourceBuilder getOrCreateInformationSource(int _index) {
		
			if (informationSource==null) {
				this.informationSource = new ArrayList<>();
			}
			InformationSource.InformationSourceBuilder result;
			return getIndex(informationSource, _index, () -> {
						InformationSource.InformationSourceBuilder newInformationSource = InformationSource.builder();
						return newInformationSource;
					});
		}
		
		@Override
		@RosettaAttribute("fxTouchSequence")
		public FxTouchSequence.FxTouchSequenceBuilder getFxTouchSequence() {
			return fxTouchSequence;
		}
		
		@Override
		public FxTouchSequence.FxTouchSequenceBuilder getOrCreateFxTouchSequence() {
			FxTouchSequence.FxTouchSequenceBuilder result;
			if (fxTouchSequence!=null) {
				result = fxTouchSequence;
			}
			else {
				result = fxTouchSequence = FxTouchSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("observationPoint")
		public List<? extends FxBusinessCenterDateTime.FxBusinessCenterDateTimeBuilder> getObservationPoint() {
			return observationPoint;
		}
		
		@Override
		public FxBusinessCenterDateTime.FxBusinessCenterDateTimeBuilder getOrCreateObservationPoint(int _index) {
		
			if (observationPoint==null) {
				this.observationPoint = new ArrayList<>();
			}
			FxBusinessCenterDateTime.FxBusinessCenterDateTimeBuilder result;
			return getIndex(observationPoint, _index, () -> {
						FxBusinessCenterDateTime.FxBusinessCenterDateTimeBuilder newObservationPoint = FxBusinessCenterDateTime.builder();
						return newObservationPoint;
					});
		}
		
		@Override
		@RosettaAttribute("touchCondition")
		public FxTouch.FxTouchBuilder setTouchCondition(TouchConditionEnum touchCondition) {
			this.touchCondition = touchCondition==null?null:touchCondition;
			return this;
		}
		@Override
		@RosettaAttribute("direction")
		public FxTouch.FxTouchBuilder setDirection(TriggerConditionEnum direction) {
			this.direction = direction==null?null:direction;
			return this;
		}
		@Override
		@RosettaAttribute("quotedCurrencyPair")
		public FxTouch.FxTouchBuilder setQuotedCurrencyPair(QuotedCurrencyPair quotedCurrencyPair) {
			this.quotedCurrencyPair = quotedCurrencyPair==null?null:quotedCurrencyPair.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("triggerRate")
		public FxTouch.FxTouchBuilder setTriggerRate(BigDecimal triggerRate) {
			this.triggerRate = triggerRate==null?null:triggerRate;
			return this;
		}
		@Override
		@RosettaAttribute("spotRate")
		public FxTouch.FxTouchBuilder setSpotRate(BigDecimal spotRate) {
			this.spotRate = spotRate==null?null:spotRate;
			return this;
		}
		@Override
		@RosettaAttribute("informationSource")
		public FxTouch.FxTouchBuilder addInformationSource(InformationSource informationSource) {
			if (informationSource!=null) this.informationSource.add(informationSource.toBuilder());
			return this;
		}
		
		@Override
		public FxTouch.FxTouchBuilder addInformationSource(InformationSource informationSource, int _idx) {
			getIndex(this.informationSource, _idx, () -> informationSource.toBuilder());
			return this;
		}
		@Override 
		public FxTouch.FxTouchBuilder addInformationSource(List<? extends InformationSource> informationSources) {
			if (informationSources != null) {
				for (InformationSource toAdd : informationSources) {
					this.informationSource.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public FxTouch.FxTouchBuilder setInformationSource(List<? extends InformationSource> informationSources) {
			if (informationSources == null)  {
				this.informationSource = new ArrayList<>();
			}
			else {
				this.informationSource = informationSources.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("fxTouchSequence")
		public FxTouch.FxTouchBuilder setFxTouchSequence(FxTouchSequence fxTouchSequence) {
			this.fxTouchSequence = fxTouchSequence==null?null:fxTouchSequence.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("observationPoint")
		public FxTouch.FxTouchBuilder addObservationPoint(FxBusinessCenterDateTime observationPoint) {
			if (observationPoint!=null) this.observationPoint.add(observationPoint.toBuilder());
			return this;
		}
		
		@Override
		public FxTouch.FxTouchBuilder addObservationPoint(FxBusinessCenterDateTime observationPoint, int _idx) {
			getIndex(this.observationPoint, _idx, () -> observationPoint.toBuilder());
			return this;
		}
		@Override 
		public FxTouch.FxTouchBuilder addObservationPoint(List<? extends FxBusinessCenterDateTime> observationPoints) {
			if (observationPoints != null) {
				for (FxBusinessCenterDateTime toAdd : observationPoints) {
					this.observationPoint.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public FxTouch.FxTouchBuilder setObservationPoint(List<? extends FxBusinessCenterDateTime> observationPoints) {
			if (observationPoints == null)  {
				this.observationPoint = new ArrayList<>();
			}
			else {
				this.observationPoint = observationPoints.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public FxTouch build() {
			return new FxTouch.FxTouchImpl(this);
		}
		
		@Override
		public FxTouch.FxTouchBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxTouch.FxTouchBuilder prune() {
			if (quotedCurrencyPair!=null && !quotedCurrencyPair.prune().hasData()) quotedCurrencyPair = null;
			informationSource = informationSource.stream().filter(b->b!=null).<InformationSource.InformationSourceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (fxTouchSequence!=null && !fxTouchSequence.prune().hasData()) fxTouchSequence = null;
			observationPoint = observationPoint.stream().filter(b->b!=null).<FxBusinessCenterDateTime.FxBusinessCenterDateTimeBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTouchCondition()!=null) return true;
			if (getDirection()!=null) return true;
			if (getQuotedCurrencyPair()!=null && getQuotedCurrencyPair().hasData()) return true;
			if (getTriggerRate()!=null) return true;
			if (getSpotRate()!=null) return true;
			if (getInformationSource()!=null && getInformationSource().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getFxTouchSequence()!=null && getFxTouchSequence().hasData()) return true;
			if (getObservationPoint()!=null && getObservationPoint().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxTouch.FxTouchBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxTouch.FxTouchBuilder o = (FxTouch.FxTouchBuilder) other;
			
			merger.mergeRosetta(getQuotedCurrencyPair(), o.getQuotedCurrencyPair(), this::setQuotedCurrencyPair);
			merger.mergeRosetta(getInformationSource(), o.getInformationSource(), this::getOrCreateInformationSource);
			merger.mergeRosetta(getFxTouchSequence(), o.getFxTouchSequence(), this::setFxTouchSequence);
			merger.mergeRosetta(getObservationPoint(), o.getObservationPoint(), this::getOrCreateObservationPoint);
			
			merger.mergeBasic(getTouchCondition(), o.getTouchCondition(), this::setTouchCondition);
			merger.mergeBasic(getDirection(), o.getDirection(), this::setDirection);
			merger.mergeBasic(getTriggerRate(), o.getTriggerRate(), this::setTriggerRate);
			merger.mergeBasic(getSpotRate(), o.getSpotRate(), this::setSpotRate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxTouch _that = getType().cast(o);
		
			if (!Objects.equals(touchCondition, _that.getTouchCondition())) return false;
			if (!Objects.equals(direction, _that.getDirection())) return false;
			if (!Objects.equals(quotedCurrencyPair, _that.getQuotedCurrencyPair())) return false;
			if (!Objects.equals(triggerRate, _that.getTriggerRate())) return false;
			if (!Objects.equals(spotRate, _that.getSpotRate())) return false;
			if (!ListEquals.listEquals(informationSource, _that.getInformationSource())) return false;
			if (!Objects.equals(fxTouchSequence, _that.getFxTouchSequence())) return false;
			if (!ListEquals.listEquals(observationPoint, _that.getObservationPoint())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (touchCondition != null ? touchCondition.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (direction != null ? direction.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (quotedCurrencyPair != null ? quotedCurrencyPair.hashCode() : 0);
			_result = 31 * _result + (triggerRate != null ? triggerRate.hashCode() : 0);
			_result = 31 * _result + (spotRate != null ? spotRate.hashCode() : 0);
			_result = 31 * _result + (informationSource != null ? informationSource.hashCode() : 0);
			_result = 31 * _result + (fxTouchSequence != null ? fxTouchSequence.hashCode() : 0);
			_result = 31 * _result + (observationPoint != null ? observationPoint.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxTouchBuilder {" +
				"touchCondition=" + this.touchCondition + ", " +
				"direction=" + this.direction + ", " +
				"quotedCurrencyPair=" + this.quotedCurrencyPair + ", " +
				"triggerRate=" + this.triggerRate + ", " +
				"spotRate=" + this.spotRate + ", " +
				"informationSource=" + this.informationSource + ", " +
				"fxTouchSequence=" + this.fxTouchSequence + ", " +
				"observationPoint=" + this.observationPoint +
			'}';
		}
	}
}
