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
import fpml.confirmation.CommoditySettlementPeriodsPriceSchedule;
import fpml.confirmation.CommoditySettlementPeriodsPriceSchedule.CommoditySettlementPeriodsPriceScheduleBuilder;
import fpml.confirmation.CommoditySettlementPeriodsPriceSchedule.CommoditySettlementPeriodsPriceScheduleBuilderImpl;
import fpml.confirmation.CommoditySettlementPeriodsPriceSchedule.CommoditySettlementPeriodsPriceScheduleImpl;
import fpml.confirmation.FixedPrice;
import fpml.confirmation.SettlementPeriodsReference;
import fpml.confirmation.meta.CommoditySettlementPeriodsPriceScheduleMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * The fixed price schedule for electricity that applies to one or more groups of Settlement Periods.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="CommoditySettlementPeriodsPriceSchedule", builder=CommoditySettlementPeriodsPriceSchedule.CommoditySettlementPeriodsPriceScheduleBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface CommoditySettlementPeriodsPriceSchedule extends RosettaModelObject {

	CommoditySettlementPeriodsPriceScheduleMeta metaData = new CommoditySettlementPeriodsPriceScheduleMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * For an electricity transaction, the Fixed Price for a given Calculation Period during the life of the trade which applies to the range(s) of Settlement Periods referenced by settlementPeriods Reference. There must be a Fixed Price step specified for each Calculation Period, regardless of whether the Fixed Price changes or remains the same between periods.
	 */
	List<? extends FixedPrice> getSettlementPeriodsPriceStep();
	/**
	 * The range(s) of Settlement Periods to which the Fixed Price steps apply.
	 */
	List<? extends SettlementPeriodsReference> getSettlementPeriodsReference();

	/*********************** Build Methods  ***********************/
	CommoditySettlementPeriodsPriceSchedule build();
	
	CommoditySettlementPeriodsPriceSchedule.CommoditySettlementPeriodsPriceScheduleBuilder toBuilder();
	
	static CommoditySettlementPeriodsPriceSchedule.CommoditySettlementPeriodsPriceScheduleBuilder builder() {
		return new CommoditySettlementPeriodsPriceSchedule.CommoditySettlementPeriodsPriceScheduleBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommoditySettlementPeriodsPriceSchedule> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommoditySettlementPeriodsPriceSchedule> getType() {
		return CommoditySettlementPeriodsPriceSchedule.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("settlementPeriodsPriceStep"), processor, FixedPrice.class, getSettlementPeriodsPriceStep());
		processRosetta(path.newSubPath("settlementPeriodsReference"), processor, SettlementPeriodsReference.class, getSettlementPeriodsReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommoditySettlementPeriodsPriceScheduleBuilder extends CommoditySettlementPeriodsPriceSchedule, RosettaModelObjectBuilder {
		FixedPrice.FixedPriceBuilder getOrCreateSettlementPeriodsPriceStep(int _index);
		List<? extends FixedPrice.FixedPriceBuilder> getSettlementPeriodsPriceStep();
		SettlementPeriodsReference.SettlementPeriodsReferenceBuilder getOrCreateSettlementPeriodsReference(int _index);
		List<? extends SettlementPeriodsReference.SettlementPeriodsReferenceBuilder> getSettlementPeriodsReference();
		CommoditySettlementPeriodsPriceSchedule.CommoditySettlementPeriodsPriceScheduleBuilder addSettlementPeriodsPriceStep(FixedPrice settlementPeriodsPriceStep0);
		CommoditySettlementPeriodsPriceSchedule.CommoditySettlementPeriodsPriceScheduleBuilder addSettlementPeriodsPriceStep(FixedPrice settlementPeriodsPriceStep1, int _idx);
		CommoditySettlementPeriodsPriceSchedule.CommoditySettlementPeriodsPriceScheduleBuilder addSettlementPeriodsPriceStep(List<? extends FixedPrice> settlementPeriodsPriceStep2);
		CommoditySettlementPeriodsPriceSchedule.CommoditySettlementPeriodsPriceScheduleBuilder setSettlementPeriodsPriceStep(List<? extends FixedPrice> settlementPeriodsPriceStep3);
		CommoditySettlementPeriodsPriceSchedule.CommoditySettlementPeriodsPriceScheduleBuilder addSettlementPeriodsReference(SettlementPeriodsReference settlementPeriodsReference0);
		CommoditySettlementPeriodsPriceSchedule.CommoditySettlementPeriodsPriceScheduleBuilder addSettlementPeriodsReference(SettlementPeriodsReference settlementPeriodsReference1, int _idx);
		CommoditySettlementPeriodsPriceSchedule.CommoditySettlementPeriodsPriceScheduleBuilder addSettlementPeriodsReference(List<? extends SettlementPeriodsReference> settlementPeriodsReference2);
		CommoditySettlementPeriodsPriceSchedule.CommoditySettlementPeriodsPriceScheduleBuilder setSettlementPeriodsReference(List<? extends SettlementPeriodsReference> settlementPeriodsReference3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("settlementPeriodsPriceStep"), processor, FixedPrice.FixedPriceBuilder.class, getSettlementPeriodsPriceStep());
			processRosetta(path.newSubPath("settlementPeriodsReference"), processor, SettlementPeriodsReference.SettlementPeriodsReferenceBuilder.class, getSettlementPeriodsReference());
		}
		

		CommoditySettlementPeriodsPriceSchedule.CommoditySettlementPeriodsPriceScheduleBuilder prune();
	}

	/*********************** Immutable Implementation of CommoditySettlementPeriodsPriceSchedule  ***********************/
	class CommoditySettlementPeriodsPriceScheduleImpl implements CommoditySettlementPeriodsPriceSchedule {
		private final List<? extends FixedPrice> settlementPeriodsPriceStep;
		private final List<? extends SettlementPeriodsReference> settlementPeriodsReference;
		
		protected CommoditySettlementPeriodsPriceScheduleImpl(CommoditySettlementPeriodsPriceSchedule.CommoditySettlementPeriodsPriceScheduleBuilder builder) {
			this.settlementPeriodsPriceStep = ofNullable(builder.getSettlementPeriodsPriceStep()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.settlementPeriodsReference = ofNullable(builder.getSettlementPeriodsReference()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("settlementPeriodsPriceStep")
		public List<? extends FixedPrice> getSettlementPeriodsPriceStep() {
			return settlementPeriodsPriceStep;
		}
		
		@Override
		@RosettaAttribute("settlementPeriodsReference")
		public List<? extends SettlementPeriodsReference> getSettlementPeriodsReference() {
			return settlementPeriodsReference;
		}
		
		@Override
		public CommoditySettlementPeriodsPriceSchedule build() {
			return this;
		}
		
		@Override
		public CommoditySettlementPeriodsPriceSchedule.CommoditySettlementPeriodsPriceScheduleBuilder toBuilder() {
			CommoditySettlementPeriodsPriceSchedule.CommoditySettlementPeriodsPriceScheduleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommoditySettlementPeriodsPriceSchedule.CommoditySettlementPeriodsPriceScheduleBuilder builder) {
			ofNullable(getSettlementPeriodsPriceStep()).ifPresent(builder::setSettlementPeriodsPriceStep);
			ofNullable(getSettlementPeriodsReference()).ifPresent(builder::setSettlementPeriodsReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommoditySettlementPeriodsPriceSchedule _that = getType().cast(o);
		
			if (!ListEquals.listEquals(settlementPeriodsPriceStep, _that.getSettlementPeriodsPriceStep())) return false;
			if (!ListEquals.listEquals(settlementPeriodsReference, _that.getSettlementPeriodsReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (settlementPeriodsPriceStep != null ? settlementPeriodsPriceStep.hashCode() : 0);
			_result = 31 * _result + (settlementPeriodsReference != null ? settlementPeriodsReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommoditySettlementPeriodsPriceSchedule {" +
				"settlementPeriodsPriceStep=" + this.settlementPeriodsPriceStep + ", " +
				"settlementPeriodsReference=" + this.settlementPeriodsReference +
			'}';
		}
	}

	/*********************** Builder Implementation of CommoditySettlementPeriodsPriceSchedule  ***********************/
	class CommoditySettlementPeriodsPriceScheduleBuilderImpl implements CommoditySettlementPeriodsPriceSchedule.CommoditySettlementPeriodsPriceScheduleBuilder {
	
		protected List<FixedPrice.FixedPriceBuilder> settlementPeriodsPriceStep = new ArrayList<>();
		protected List<SettlementPeriodsReference.SettlementPeriodsReferenceBuilder> settlementPeriodsReference = new ArrayList<>();
	
		public CommoditySettlementPeriodsPriceScheduleBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("settlementPeriodsPriceStep")
		public List<? extends FixedPrice.FixedPriceBuilder> getSettlementPeriodsPriceStep() {
			return settlementPeriodsPriceStep;
		}
		
		@Override
		public FixedPrice.FixedPriceBuilder getOrCreateSettlementPeriodsPriceStep(int _index) {
		
			if (settlementPeriodsPriceStep==null) {
				this.settlementPeriodsPriceStep = new ArrayList<>();
			}
			FixedPrice.FixedPriceBuilder result;
			return getIndex(settlementPeriodsPriceStep, _index, () -> {
						FixedPrice.FixedPriceBuilder newSettlementPeriodsPriceStep = FixedPrice.builder();
						return newSettlementPeriodsPriceStep;
					});
		}
		
		@Override
		@RosettaAttribute("settlementPeriodsReference")
		public List<? extends SettlementPeriodsReference.SettlementPeriodsReferenceBuilder> getSettlementPeriodsReference() {
			return settlementPeriodsReference;
		}
		
		@Override
		public SettlementPeriodsReference.SettlementPeriodsReferenceBuilder getOrCreateSettlementPeriodsReference(int _index) {
		
			if (settlementPeriodsReference==null) {
				this.settlementPeriodsReference = new ArrayList<>();
			}
			SettlementPeriodsReference.SettlementPeriodsReferenceBuilder result;
			return getIndex(settlementPeriodsReference, _index, () -> {
						SettlementPeriodsReference.SettlementPeriodsReferenceBuilder newSettlementPeriodsReference = SettlementPeriodsReference.builder();
						return newSettlementPeriodsReference;
					});
		}
		
		@Override
		@RosettaAttribute("settlementPeriodsPriceStep")
		public CommoditySettlementPeriodsPriceSchedule.CommoditySettlementPeriodsPriceScheduleBuilder addSettlementPeriodsPriceStep(FixedPrice settlementPeriodsPriceStep) {
			if (settlementPeriodsPriceStep!=null) this.settlementPeriodsPriceStep.add(settlementPeriodsPriceStep.toBuilder());
			return this;
		}
		
		@Override
		public CommoditySettlementPeriodsPriceSchedule.CommoditySettlementPeriodsPriceScheduleBuilder addSettlementPeriodsPriceStep(FixedPrice settlementPeriodsPriceStep, int _idx) {
			getIndex(this.settlementPeriodsPriceStep, _idx, () -> settlementPeriodsPriceStep.toBuilder());
			return this;
		}
		@Override 
		public CommoditySettlementPeriodsPriceSchedule.CommoditySettlementPeriodsPriceScheduleBuilder addSettlementPeriodsPriceStep(List<? extends FixedPrice> settlementPeriodsPriceSteps) {
			if (settlementPeriodsPriceSteps != null) {
				for (FixedPrice toAdd : settlementPeriodsPriceSteps) {
					this.settlementPeriodsPriceStep.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public CommoditySettlementPeriodsPriceSchedule.CommoditySettlementPeriodsPriceScheduleBuilder setSettlementPeriodsPriceStep(List<? extends FixedPrice> settlementPeriodsPriceSteps) {
			if (settlementPeriodsPriceSteps == null)  {
				this.settlementPeriodsPriceStep = new ArrayList<>();
			}
			else {
				this.settlementPeriodsPriceStep = settlementPeriodsPriceSteps.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("settlementPeriodsReference")
		public CommoditySettlementPeriodsPriceSchedule.CommoditySettlementPeriodsPriceScheduleBuilder addSettlementPeriodsReference(SettlementPeriodsReference settlementPeriodsReference) {
			if (settlementPeriodsReference!=null) this.settlementPeriodsReference.add(settlementPeriodsReference.toBuilder());
			return this;
		}
		
		@Override
		public CommoditySettlementPeriodsPriceSchedule.CommoditySettlementPeriodsPriceScheduleBuilder addSettlementPeriodsReference(SettlementPeriodsReference settlementPeriodsReference, int _idx) {
			getIndex(this.settlementPeriodsReference, _idx, () -> settlementPeriodsReference.toBuilder());
			return this;
		}
		@Override 
		public CommoditySettlementPeriodsPriceSchedule.CommoditySettlementPeriodsPriceScheduleBuilder addSettlementPeriodsReference(List<? extends SettlementPeriodsReference> settlementPeriodsReferences) {
			if (settlementPeriodsReferences != null) {
				for (SettlementPeriodsReference toAdd : settlementPeriodsReferences) {
					this.settlementPeriodsReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public CommoditySettlementPeriodsPriceSchedule.CommoditySettlementPeriodsPriceScheduleBuilder setSettlementPeriodsReference(List<? extends SettlementPeriodsReference> settlementPeriodsReferences) {
			if (settlementPeriodsReferences == null)  {
				this.settlementPeriodsReference = new ArrayList<>();
			}
			else {
				this.settlementPeriodsReference = settlementPeriodsReferences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public CommoditySettlementPeriodsPriceSchedule build() {
			return new CommoditySettlementPeriodsPriceSchedule.CommoditySettlementPeriodsPriceScheduleImpl(this);
		}
		
		@Override
		public CommoditySettlementPeriodsPriceSchedule.CommoditySettlementPeriodsPriceScheduleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommoditySettlementPeriodsPriceSchedule.CommoditySettlementPeriodsPriceScheduleBuilder prune() {
			settlementPeriodsPriceStep = settlementPeriodsPriceStep.stream().filter(b->b!=null).<FixedPrice.FixedPriceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			settlementPeriodsReference = settlementPeriodsReference.stream().filter(b->b!=null).<SettlementPeriodsReference.SettlementPeriodsReferenceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSettlementPeriodsPriceStep()!=null && getSettlementPeriodsPriceStep().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getSettlementPeriodsReference()!=null && getSettlementPeriodsReference().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommoditySettlementPeriodsPriceSchedule.CommoditySettlementPeriodsPriceScheduleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommoditySettlementPeriodsPriceSchedule.CommoditySettlementPeriodsPriceScheduleBuilder o = (CommoditySettlementPeriodsPriceSchedule.CommoditySettlementPeriodsPriceScheduleBuilder) other;
			
			merger.mergeRosetta(getSettlementPeriodsPriceStep(), o.getSettlementPeriodsPriceStep(), this::getOrCreateSettlementPeriodsPriceStep);
			merger.mergeRosetta(getSettlementPeriodsReference(), o.getSettlementPeriodsReference(), this::getOrCreateSettlementPeriodsReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommoditySettlementPeriodsPriceSchedule _that = getType().cast(o);
		
			if (!ListEquals.listEquals(settlementPeriodsPriceStep, _that.getSettlementPeriodsPriceStep())) return false;
			if (!ListEquals.listEquals(settlementPeriodsReference, _that.getSettlementPeriodsReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (settlementPeriodsPriceStep != null ? settlementPeriodsPriceStep.hashCode() : 0);
			_result = 31 * _result + (settlementPeriodsReference != null ? settlementPeriodsReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommoditySettlementPeriodsPriceScheduleBuilder {" +
				"settlementPeriodsPriceStep=" + this.settlementPeriodsPriceStep + ", " +
				"settlementPeriodsReference=" + this.settlementPeriodsReference +
			'}';
		}
	}
}
