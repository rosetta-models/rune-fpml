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
import fpml.confirmation.FxBarrierDirectionEnum;
import fpml.confirmation.FxBarrierFeature;
import fpml.confirmation.FxBarrierFeature.FxBarrierFeatureBuilder;
import fpml.confirmation.FxBarrierFeature.FxBarrierFeatureBuilderImpl;
import fpml.confirmation.FxBarrierFeature.FxBarrierFeatureImpl;
import fpml.confirmation.FxBarrierFeatureSequence;
import fpml.confirmation.FxBarrierTypeEnum;
import fpml.confirmation.FxBusinessCenterDateTime;
import fpml.confirmation.InformationSource;
import fpml.confirmation.QuotedCurrencyPair;
import fpml.confirmation.meta.FxBarrierFeatureMeta;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Describes the properties of an FX barrier.
 * @version ${project.version}
 */
@RosettaDataType(value="FxBarrierFeature", builder=FxBarrierFeature.FxBarrierFeatureBuilderImpl.class, version="${project.version}")
public interface FxBarrierFeature extends RosettaModelObject {

	FxBarrierFeatureMeta metaData = new FxBarrierFeatureMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * This specifies whether the option becomes effective (&quot;knock-in&quot;) or is annulled (&quot;knock-out&quot;) when the respective barrier event occurs.
	 */
	FxBarrierTypeEnum getBarrierType();
	/**
	 * This specifies whether the barrier direction is &quot;Up&quot; or &quot;Down&quot;; that is, that a barrier event occurs if the spot rate is at or above the trigger rate, or at or below the trigger rate during the period of observation of an american barrier, or at the times of observation of a discrete or european barrier.
	 */
	FxBarrierDirectionEnum getDirection();
	/**
	 * Defines the two currencies for an FX trade and the quotation relationship between the two currencies.
	 */
	QuotedCurrencyPair getQuotedCurrencyPair();
	/**
	 * The market rate is observed relative to the trigger rate, and if it is found to be on the predefined side of (above or below) the trigger rate, a trigger event is deemed to have occurred.
	 */
	BigDecimal getTriggerRate();
	/**
	 * The information source where a published or displayed market rate will be obtained, e.g. Telerate Page 3750.
	 */
	List<? extends InformationSource> getInformationSource();
	FxBarrierFeatureSequence getFxBarrierFeatureSequence();
	/**
	 * The dates and times at which rate observations are made to determine whether a barrier event has occurred for a discrete or european barrier. If the time is not present then the time is deemed to be the same as the expiration time.
	 */
	List<? extends FxBusinessCenterDateTime> getObservationPoint();

	/*********************** Build Methods  ***********************/
	FxBarrierFeature build();
	
	FxBarrierFeature.FxBarrierFeatureBuilder toBuilder();
	
	static FxBarrierFeature.FxBarrierFeatureBuilder builder() {
		return new FxBarrierFeature.FxBarrierFeatureBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxBarrierFeature> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxBarrierFeature> getType() {
		return FxBarrierFeature.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("barrierType"), FxBarrierTypeEnum.class, getBarrierType(), this);
		processor.processBasic(path.newSubPath("direction"), FxBarrierDirectionEnum.class, getDirection(), this);
		processRosetta(path.newSubPath("quotedCurrencyPair"), processor, QuotedCurrencyPair.class, getQuotedCurrencyPair());
		processor.processBasic(path.newSubPath("triggerRate"), BigDecimal.class, getTriggerRate(), this);
		processRosetta(path.newSubPath("informationSource"), processor, InformationSource.class, getInformationSource());
		processRosetta(path.newSubPath("fxBarrierFeatureSequence"), processor, FxBarrierFeatureSequence.class, getFxBarrierFeatureSequence());
		processRosetta(path.newSubPath("observationPoint"), processor, FxBusinessCenterDateTime.class, getObservationPoint());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxBarrierFeatureBuilder extends FxBarrierFeature, RosettaModelObjectBuilder {
		QuotedCurrencyPair.QuotedCurrencyPairBuilder getOrCreateQuotedCurrencyPair();
		QuotedCurrencyPair.QuotedCurrencyPairBuilder getQuotedCurrencyPair();
		InformationSource.InformationSourceBuilder getOrCreateInformationSource(int _index);
		List<? extends InformationSource.InformationSourceBuilder> getInformationSource();
		FxBarrierFeatureSequence.FxBarrierFeatureSequenceBuilder getOrCreateFxBarrierFeatureSequence();
		FxBarrierFeatureSequence.FxBarrierFeatureSequenceBuilder getFxBarrierFeatureSequence();
		FxBusinessCenterDateTime.FxBusinessCenterDateTimeBuilder getOrCreateObservationPoint(int _index);
		List<? extends FxBusinessCenterDateTime.FxBusinessCenterDateTimeBuilder> getObservationPoint();
		FxBarrierFeature.FxBarrierFeatureBuilder setBarrierType(FxBarrierTypeEnum barrierType);
		FxBarrierFeature.FxBarrierFeatureBuilder setDirection(FxBarrierDirectionEnum direction);
		FxBarrierFeature.FxBarrierFeatureBuilder setQuotedCurrencyPair(QuotedCurrencyPair quotedCurrencyPair);
		FxBarrierFeature.FxBarrierFeatureBuilder setTriggerRate(BigDecimal triggerRate);
		FxBarrierFeature.FxBarrierFeatureBuilder addInformationSource(InformationSource informationSource0);
		FxBarrierFeature.FxBarrierFeatureBuilder addInformationSource(InformationSource informationSource1, int _idx);
		FxBarrierFeature.FxBarrierFeatureBuilder addInformationSource(List<? extends InformationSource> informationSource2);
		FxBarrierFeature.FxBarrierFeatureBuilder setInformationSource(List<? extends InformationSource> informationSource3);
		FxBarrierFeature.FxBarrierFeatureBuilder setFxBarrierFeatureSequence(FxBarrierFeatureSequence fxBarrierFeatureSequence);
		FxBarrierFeature.FxBarrierFeatureBuilder addObservationPoint(FxBusinessCenterDateTime observationPoint0);
		FxBarrierFeature.FxBarrierFeatureBuilder addObservationPoint(FxBusinessCenterDateTime observationPoint1, int _idx);
		FxBarrierFeature.FxBarrierFeatureBuilder addObservationPoint(List<? extends FxBusinessCenterDateTime> observationPoint2);
		FxBarrierFeature.FxBarrierFeatureBuilder setObservationPoint(List<? extends FxBusinessCenterDateTime> observationPoint3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("barrierType"), FxBarrierTypeEnum.class, getBarrierType(), this);
			processor.processBasic(path.newSubPath("direction"), FxBarrierDirectionEnum.class, getDirection(), this);
			processRosetta(path.newSubPath("quotedCurrencyPair"), processor, QuotedCurrencyPair.QuotedCurrencyPairBuilder.class, getQuotedCurrencyPair());
			processor.processBasic(path.newSubPath("triggerRate"), BigDecimal.class, getTriggerRate(), this);
			processRosetta(path.newSubPath("informationSource"), processor, InformationSource.InformationSourceBuilder.class, getInformationSource());
			processRosetta(path.newSubPath("fxBarrierFeatureSequence"), processor, FxBarrierFeatureSequence.FxBarrierFeatureSequenceBuilder.class, getFxBarrierFeatureSequence());
			processRosetta(path.newSubPath("observationPoint"), processor, FxBusinessCenterDateTime.FxBusinessCenterDateTimeBuilder.class, getObservationPoint());
		}
		

		FxBarrierFeature.FxBarrierFeatureBuilder prune();
	}

	/*********************** Immutable Implementation of FxBarrierFeature  ***********************/
	class FxBarrierFeatureImpl implements FxBarrierFeature {
		private final FxBarrierTypeEnum barrierType;
		private final FxBarrierDirectionEnum direction;
		private final QuotedCurrencyPair quotedCurrencyPair;
		private final BigDecimal triggerRate;
		private final List<? extends InformationSource> informationSource;
		private final FxBarrierFeatureSequence fxBarrierFeatureSequence;
		private final List<? extends FxBusinessCenterDateTime> observationPoint;
		
		protected FxBarrierFeatureImpl(FxBarrierFeature.FxBarrierFeatureBuilder builder) {
			this.barrierType = builder.getBarrierType();
			this.direction = builder.getDirection();
			this.quotedCurrencyPair = ofNullable(builder.getQuotedCurrencyPair()).map(f->f.build()).orElse(null);
			this.triggerRate = builder.getTriggerRate();
			this.informationSource = ofNullable(builder.getInformationSource()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.fxBarrierFeatureSequence = ofNullable(builder.getFxBarrierFeatureSequence()).map(f->f.build()).orElse(null);
			this.observationPoint = ofNullable(builder.getObservationPoint()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("barrierType")
		public FxBarrierTypeEnum getBarrierType() {
			return barrierType;
		}
		
		@Override
		@RosettaAttribute("direction")
		public FxBarrierDirectionEnum getDirection() {
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
		@RosettaAttribute("informationSource")
		public List<? extends InformationSource> getInformationSource() {
			return informationSource;
		}
		
		@Override
		@RosettaAttribute("fxBarrierFeatureSequence")
		public FxBarrierFeatureSequence getFxBarrierFeatureSequence() {
			return fxBarrierFeatureSequence;
		}
		
		@Override
		@RosettaAttribute("observationPoint")
		public List<? extends FxBusinessCenterDateTime> getObservationPoint() {
			return observationPoint;
		}
		
		@Override
		public FxBarrierFeature build() {
			return this;
		}
		
		@Override
		public FxBarrierFeature.FxBarrierFeatureBuilder toBuilder() {
			FxBarrierFeature.FxBarrierFeatureBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxBarrierFeature.FxBarrierFeatureBuilder builder) {
			ofNullable(getBarrierType()).ifPresent(builder::setBarrierType);
			ofNullable(getDirection()).ifPresent(builder::setDirection);
			ofNullable(getQuotedCurrencyPair()).ifPresent(builder::setQuotedCurrencyPair);
			ofNullable(getTriggerRate()).ifPresent(builder::setTriggerRate);
			ofNullable(getInformationSource()).ifPresent(builder::setInformationSource);
			ofNullable(getFxBarrierFeatureSequence()).ifPresent(builder::setFxBarrierFeatureSequence);
			ofNullable(getObservationPoint()).ifPresent(builder::setObservationPoint);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxBarrierFeature _that = getType().cast(o);
		
			if (!Objects.equals(barrierType, _that.getBarrierType())) return false;
			if (!Objects.equals(direction, _that.getDirection())) return false;
			if (!Objects.equals(quotedCurrencyPair, _that.getQuotedCurrencyPair())) return false;
			if (!Objects.equals(triggerRate, _that.getTriggerRate())) return false;
			if (!ListEquals.listEquals(informationSource, _that.getInformationSource())) return false;
			if (!Objects.equals(fxBarrierFeatureSequence, _that.getFxBarrierFeatureSequence())) return false;
			if (!ListEquals.listEquals(observationPoint, _that.getObservationPoint())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (barrierType != null ? barrierType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (direction != null ? direction.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (quotedCurrencyPair != null ? quotedCurrencyPair.hashCode() : 0);
			_result = 31 * _result + (triggerRate != null ? triggerRate.hashCode() : 0);
			_result = 31 * _result + (informationSource != null ? informationSource.hashCode() : 0);
			_result = 31 * _result + (fxBarrierFeatureSequence != null ? fxBarrierFeatureSequence.hashCode() : 0);
			_result = 31 * _result + (observationPoint != null ? observationPoint.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxBarrierFeature {" +
				"barrierType=" + this.barrierType + ", " +
				"direction=" + this.direction + ", " +
				"quotedCurrencyPair=" + this.quotedCurrencyPair + ", " +
				"triggerRate=" + this.triggerRate + ", " +
				"informationSource=" + this.informationSource + ", " +
				"fxBarrierFeatureSequence=" + this.fxBarrierFeatureSequence + ", " +
				"observationPoint=" + this.observationPoint +
			'}';
		}
	}

	/*********************** Builder Implementation of FxBarrierFeature  ***********************/
	class FxBarrierFeatureBuilderImpl implements FxBarrierFeature.FxBarrierFeatureBuilder {
	
		protected FxBarrierTypeEnum barrierType;
		protected FxBarrierDirectionEnum direction;
		protected QuotedCurrencyPair.QuotedCurrencyPairBuilder quotedCurrencyPair;
		protected BigDecimal triggerRate;
		protected List<InformationSource.InformationSourceBuilder> informationSource = new ArrayList<>();
		protected FxBarrierFeatureSequence.FxBarrierFeatureSequenceBuilder fxBarrierFeatureSequence;
		protected List<FxBusinessCenterDateTime.FxBusinessCenterDateTimeBuilder> observationPoint = new ArrayList<>();
	
		public FxBarrierFeatureBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("barrierType")
		public FxBarrierTypeEnum getBarrierType() {
			return barrierType;
		}
		
		@Override
		@RosettaAttribute("direction")
		public FxBarrierDirectionEnum getDirection() {
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
		@RosettaAttribute("informationSource")
		public List<? extends InformationSource.InformationSourceBuilder> getInformationSource() {
			return informationSource;
		}
		
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
		@RosettaAttribute("fxBarrierFeatureSequence")
		public FxBarrierFeatureSequence.FxBarrierFeatureSequenceBuilder getFxBarrierFeatureSequence() {
			return fxBarrierFeatureSequence;
		}
		
		@Override
		public FxBarrierFeatureSequence.FxBarrierFeatureSequenceBuilder getOrCreateFxBarrierFeatureSequence() {
			FxBarrierFeatureSequence.FxBarrierFeatureSequenceBuilder result;
			if (fxBarrierFeatureSequence!=null) {
				result = fxBarrierFeatureSequence;
			}
			else {
				result = fxBarrierFeatureSequence = FxBarrierFeatureSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("observationPoint")
		public List<? extends FxBusinessCenterDateTime.FxBusinessCenterDateTimeBuilder> getObservationPoint() {
			return observationPoint;
		}
		
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
		@RosettaAttribute("barrierType")
		public FxBarrierFeature.FxBarrierFeatureBuilder setBarrierType(FxBarrierTypeEnum barrierType) {
			this.barrierType = barrierType==null?null:barrierType;
			return this;
		}
		@Override
		@RosettaAttribute("direction")
		public FxBarrierFeature.FxBarrierFeatureBuilder setDirection(FxBarrierDirectionEnum direction) {
			this.direction = direction==null?null:direction;
			return this;
		}
		@Override
		@RosettaAttribute("quotedCurrencyPair")
		public FxBarrierFeature.FxBarrierFeatureBuilder setQuotedCurrencyPair(QuotedCurrencyPair quotedCurrencyPair) {
			this.quotedCurrencyPair = quotedCurrencyPair==null?null:quotedCurrencyPair.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("triggerRate")
		public FxBarrierFeature.FxBarrierFeatureBuilder setTriggerRate(BigDecimal triggerRate) {
			this.triggerRate = triggerRate==null?null:triggerRate;
			return this;
		}
		@Override
		public FxBarrierFeature.FxBarrierFeatureBuilder addInformationSource(InformationSource informationSource) {
			if (informationSource!=null) this.informationSource.add(informationSource.toBuilder());
			return this;
		}
		
		@Override
		public FxBarrierFeature.FxBarrierFeatureBuilder addInformationSource(InformationSource informationSource, int _idx) {
			getIndex(this.informationSource, _idx, () -> informationSource.toBuilder());
			return this;
		}
		@Override 
		public FxBarrierFeature.FxBarrierFeatureBuilder addInformationSource(List<? extends InformationSource> informationSources) {
			if (informationSources != null) {
				for (InformationSource toAdd : informationSources) {
					this.informationSource.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("informationSource")
		public FxBarrierFeature.FxBarrierFeatureBuilder setInformationSource(List<? extends InformationSource> informationSources) {
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
		@RosettaAttribute("fxBarrierFeatureSequence")
		public FxBarrierFeature.FxBarrierFeatureBuilder setFxBarrierFeatureSequence(FxBarrierFeatureSequence fxBarrierFeatureSequence) {
			this.fxBarrierFeatureSequence = fxBarrierFeatureSequence==null?null:fxBarrierFeatureSequence.toBuilder();
			return this;
		}
		@Override
		public FxBarrierFeature.FxBarrierFeatureBuilder addObservationPoint(FxBusinessCenterDateTime observationPoint) {
			if (observationPoint!=null) this.observationPoint.add(observationPoint.toBuilder());
			return this;
		}
		
		@Override
		public FxBarrierFeature.FxBarrierFeatureBuilder addObservationPoint(FxBusinessCenterDateTime observationPoint, int _idx) {
			getIndex(this.observationPoint, _idx, () -> observationPoint.toBuilder());
			return this;
		}
		@Override 
		public FxBarrierFeature.FxBarrierFeatureBuilder addObservationPoint(List<? extends FxBusinessCenterDateTime> observationPoints) {
			if (observationPoints != null) {
				for (FxBusinessCenterDateTime toAdd : observationPoints) {
					this.observationPoint.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("observationPoint")
		public FxBarrierFeature.FxBarrierFeatureBuilder setObservationPoint(List<? extends FxBusinessCenterDateTime> observationPoints) {
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
		public FxBarrierFeature build() {
			return new FxBarrierFeature.FxBarrierFeatureImpl(this);
		}
		
		@Override
		public FxBarrierFeature.FxBarrierFeatureBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxBarrierFeature.FxBarrierFeatureBuilder prune() {
			if (quotedCurrencyPair!=null && !quotedCurrencyPair.prune().hasData()) quotedCurrencyPair = null;
			informationSource = informationSource.stream().filter(b->b!=null).<InformationSource.InformationSourceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (fxBarrierFeatureSequence!=null && !fxBarrierFeatureSequence.prune().hasData()) fxBarrierFeatureSequence = null;
			observationPoint = observationPoint.stream().filter(b->b!=null).<FxBusinessCenterDateTime.FxBusinessCenterDateTimeBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBarrierType()!=null) return true;
			if (getDirection()!=null) return true;
			if (getQuotedCurrencyPair()!=null && getQuotedCurrencyPair().hasData()) return true;
			if (getTriggerRate()!=null) return true;
			if (getInformationSource()!=null && getInformationSource().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getFxBarrierFeatureSequence()!=null && getFxBarrierFeatureSequence().hasData()) return true;
			if (getObservationPoint()!=null && getObservationPoint().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxBarrierFeature.FxBarrierFeatureBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxBarrierFeature.FxBarrierFeatureBuilder o = (FxBarrierFeature.FxBarrierFeatureBuilder) other;
			
			merger.mergeRosetta(getQuotedCurrencyPair(), o.getQuotedCurrencyPair(), this::setQuotedCurrencyPair);
			merger.mergeRosetta(getInformationSource(), o.getInformationSource(), this::getOrCreateInformationSource);
			merger.mergeRosetta(getFxBarrierFeatureSequence(), o.getFxBarrierFeatureSequence(), this::setFxBarrierFeatureSequence);
			merger.mergeRosetta(getObservationPoint(), o.getObservationPoint(), this::getOrCreateObservationPoint);
			
			merger.mergeBasic(getBarrierType(), o.getBarrierType(), this::setBarrierType);
			merger.mergeBasic(getDirection(), o.getDirection(), this::setDirection);
			merger.mergeBasic(getTriggerRate(), o.getTriggerRate(), this::setTriggerRate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxBarrierFeature _that = getType().cast(o);
		
			if (!Objects.equals(barrierType, _that.getBarrierType())) return false;
			if (!Objects.equals(direction, _that.getDirection())) return false;
			if (!Objects.equals(quotedCurrencyPair, _that.getQuotedCurrencyPair())) return false;
			if (!Objects.equals(triggerRate, _that.getTriggerRate())) return false;
			if (!ListEquals.listEquals(informationSource, _that.getInformationSource())) return false;
			if (!Objects.equals(fxBarrierFeatureSequence, _that.getFxBarrierFeatureSequence())) return false;
			if (!ListEquals.listEquals(observationPoint, _that.getObservationPoint())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (barrierType != null ? barrierType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (direction != null ? direction.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (quotedCurrencyPair != null ? quotedCurrencyPair.hashCode() : 0);
			_result = 31 * _result + (triggerRate != null ? triggerRate.hashCode() : 0);
			_result = 31 * _result + (informationSource != null ? informationSource.hashCode() : 0);
			_result = 31 * _result + (fxBarrierFeatureSequence != null ? fxBarrierFeatureSequence.hashCode() : 0);
			_result = 31 * _result + (observationPoint != null ? observationPoint.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxBarrierFeatureBuilder {" +
				"barrierType=" + this.barrierType + ", " +
				"direction=" + this.direction + ", " +
				"quotedCurrencyPair=" + this.quotedCurrencyPair + ", " +
				"triggerRate=" + this.triggerRate + ", " +
				"informationSource=" + this.informationSource + ", " +
				"fxBarrierFeatureSequence=" + this.fxBarrierFeatureSequence + ", " +
				"observationPoint=" + this.observationPoint +
			'}';
		}
	}
}
