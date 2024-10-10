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
import fpml.confirmation.CommodityNotionalQuantity;
import fpml.confirmation.CommoditySettlementPeriodsNotionalQuantitySchedule;
import fpml.confirmation.CommoditySettlementPeriodsNotionalQuantitySchedule.CommoditySettlementPeriodsNotionalQuantityScheduleBuilder;
import fpml.confirmation.CommoditySettlementPeriodsNotionalQuantitySchedule.CommoditySettlementPeriodsNotionalQuantityScheduleBuilderImpl;
import fpml.confirmation.CommoditySettlementPeriodsNotionalQuantitySchedule.CommoditySettlementPeriodsNotionalQuantityScheduleImpl;
import fpml.confirmation.SettlementPeriodsReference;
import fpml.confirmation.meta.CommoditySettlementPeriodsNotionalQuantityScheduleMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * The notional quantity schedule of electricity that applies to one or more groups of Settlement Periods.
 * @version ${project.version}
 */
@RosettaDataType(value="CommoditySettlementPeriodsNotionalQuantitySchedule", builder=CommoditySettlementPeriodsNotionalQuantitySchedule.CommoditySettlementPeriodsNotionalQuantityScheduleBuilderImpl.class, version="${project.version}")
public interface CommoditySettlementPeriodsNotionalQuantitySchedule extends RosettaModelObject {

	CommoditySettlementPeriodsNotionalQuantityScheduleMeta metaData = new CommoditySettlementPeriodsNotionalQuantityScheduleMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * For an electricity transaction, the Notional Quantity for a given Calculation Period during the life of the trade which applies to the range(s) of Settlement Periods referenced by settlementPeriodsReference. There must be a settlementPeriodsNotionalQuantityStep specified for each Calculation Period, regardless of whether the NotionalQuantity changes or remains the same between periods.
	 */
	List<? extends CommodityNotionalQuantity> getSettlementPeriodsNotionalQuantityStep();
	/**
	 * The range(s) of Settlement Periods to which the Fixed Price steps apply.
	 */
	List<? extends SettlementPeriodsReference> getSettlementPeriodsReference();

	/*********************** Build Methods  ***********************/
	CommoditySettlementPeriodsNotionalQuantitySchedule build();
	
	CommoditySettlementPeriodsNotionalQuantitySchedule.CommoditySettlementPeriodsNotionalQuantityScheduleBuilder toBuilder();
	
	static CommoditySettlementPeriodsNotionalQuantitySchedule.CommoditySettlementPeriodsNotionalQuantityScheduleBuilder builder() {
		return new CommoditySettlementPeriodsNotionalQuantitySchedule.CommoditySettlementPeriodsNotionalQuantityScheduleBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommoditySettlementPeriodsNotionalQuantitySchedule> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommoditySettlementPeriodsNotionalQuantitySchedule> getType() {
		return CommoditySettlementPeriodsNotionalQuantitySchedule.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("settlementPeriodsNotionalQuantityStep"), processor, CommodityNotionalQuantity.class, getSettlementPeriodsNotionalQuantityStep());
		processRosetta(path.newSubPath("settlementPeriodsReference"), processor, SettlementPeriodsReference.class, getSettlementPeriodsReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommoditySettlementPeriodsNotionalQuantityScheduleBuilder extends CommoditySettlementPeriodsNotionalQuantitySchedule, RosettaModelObjectBuilder {
		CommodityNotionalQuantity.CommodityNotionalQuantityBuilder getOrCreateSettlementPeriodsNotionalQuantityStep(int _index);
		List<? extends CommodityNotionalQuantity.CommodityNotionalQuantityBuilder> getSettlementPeriodsNotionalQuantityStep();
		SettlementPeriodsReference.SettlementPeriodsReferenceBuilder getOrCreateSettlementPeriodsReference(int _index);
		List<? extends SettlementPeriodsReference.SettlementPeriodsReferenceBuilder> getSettlementPeriodsReference();
		CommoditySettlementPeriodsNotionalQuantitySchedule.CommoditySettlementPeriodsNotionalQuantityScheduleBuilder addSettlementPeriodsNotionalQuantityStep(CommodityNotionalQuantity settlementPeriodsNotionalQuantityStep0);
		CommoditySettlementPeriodsNotionalQuantitySchedule.CommoditySettlementPeriodsNotionalQuantityScheduleBuilder addSettlementPeriodsNotionalQuantityStep(CommodityNotionalQuantity settlementPeriodsNotionalQuantityStep1, int _idx);
		CommoditySettlementPeriodsNotionalQuantitySchedule.CommoditySettlementPeriodsNotionalQuantityScheduleBuilder addSettlementPeriodsNotionalQuantityStep(List<? extends CommodityNotionalQuantity> settlementPeriodsNotionalQuantityStep2);
		CommoditySettlementPeriodsNotionalQuantitySchedule.CommoditySettlementPeriodsNotionalQuantityScheduleBuilder setSettlementPeriodsNotionalQuantityStep(List<? extends CommodityNotionalQuantity> settlementPeriodsNotionalQuantityStep3);
		CommoditySettlementPeriodsNotionalQuantitySchedule.CommoditySettlementPeriodsNotionalQuantityScheduleBuilder addSettlementPeriodsReference(SettlementPeriodsReference settlementPeriodsReference0);
		CommoditySettlementPeriodsNotionalQuantitySchedule.CommoditySettlementPeriodsNotionalQuantityScheduleBuilder addSettlementPeriodsReference(SettlementPeriodsReference settlementPeriodsReference1, int _idx);
		CommoditySettlementPeriodsNotionalQuantitySchedule.CommoditySettlementPeriodsNotionalQuantityScheduleBuilder addSettlementPeriodsReference(List<? extends SettlementPeriodsReference> settlementPeriodsReference2);
		CommoditySettlementPeriodsNotionalQuantitySchedule.CommoditySettlementPeriodsNotionalQuantityScheduleBuilder setSettlementPeriodsReference(List<? extends SettlementPeriodsReference> settlementPeriodsReference3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("settlementPeriodsNotionalQuantityStep"), processor, CommodityNotionalQuantity.CommodityNotionalQuantityBuilder.class, getSettlementPeriodsNotionalQuantityStep());
			processRosetta(path.newSubPath("settlementPeriodsReference"), processor, SettlementPeriodsReference.SettlementPeriodsReferenceBuilder.class, getSettlementPeriodsReference());
		}
		

		CommoditySettlementPeriodsNotionalQuantitySchedule.CommoditySettlementPeriodsNotionalQuantityScheduleBuilder prune();
	}

	/*********************** Immutable Implementation of CommoditySettlementPeriodsNotionalQuantitySchedule  ***********************/
	class CommoditySettlementPeriodsNotionalQuantityScheduleImpl implements CommoditySettlementPeriodsNotionalQuantitySchedule {
		private final List<? extends CommodityNotionalQuantity> settlementPeriodsNotionalQuantityStep;
		private final List<? extends SettlementPeriodsReference> settlementPeriodsReference;
		
		protected CommoditySettlementPeriodsNotionalQuantityScheduleImpl(CommoditySettlementPeriodsNotionalQuantitySchedule.CommoditySettlementPeriodsNotionalQuantityScheduleBuilder builder) {
			this.settlementPeriodsNotionalQuantityStep = ofNullable(builder.getSettlementPeriodsNotionalQuantityStep()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.settlementPeriodsReference = ofNullable(builder.getSettlementPeriodsReference()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("settlementPeriodsNotionalQuantityStep")
		public List<? extends CommodityNotionalQuantity> getSettlementPeriodsNotionalQuantityStep() {
			return settlementPeriodsNotionalQuantityStep;
		}
		
		@Override
		@RosettaAttribute("settlementPeriodsReference")
		public List<? extends SettlementPeriodsReference> getSettlementPeriodsReference() {
			return settlementPeriodsReference;
		}
		
		@Override
		public CommoditySettlementPeriodsNotionalQuantitySchedule build() {
			return this;
		}
		
		@Override
		public CommoditySettlementPeriodsNotionalQuantitySchedule.CommoditySettlementPeriodsNotionalQuantityScheduleBuilder toBuilder() {
			CommoditySettlementPeriodsNotionalQuantitySchedule.CommoditySettlementPeriodsNotionalQuantityScheduleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommoditySettlementPeriodsNotionalQuantitySchedule.CommoditySettlementPeriodsNotionalQuantityScheduleBuilder builder) {
			ofNullable(getSettlementPeriodsNotionalQuantityStep()).ifPresent(builder::setSettlementPeriodsNotionalQuantityStep);
			ofNullable(getSettlementPeriodsReference()).ifPresent(builder::setSettlementPeriodsReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommoditySettlementPeriodsNotionalQuantitySchedule _that = getType().cast(o);
		
			if (!ListEquals.listEquals(settlementPeriodsNotionalQuantityStep, _that.getSettlementPeriodsNotionalQuantityStep())) return false;
			if (!ListEquals.listEquals(settlementPeriodsReference, _that.getSettlementPeriodsReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (settlementPeriodsNotionalQuantityStep != null ? settlementPeriodsNotionalQuantityStep.hashCode() : 0);
			_result = 31 * _result + (settlementPeriodsReference != null ? settlementPeriodsReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommoditySettlementPeriodsNotionalQuantitySchedule {" +
				"settlementPeriodsNotionalQuantityStep=" + this.settlementPeriodsNotionalQuantityStep + ", " +
				"settlementPeriodsReference=" + this.settlementPeriodsReference +
			'}';
		}
	}

	/*********************** Builder Implementation of CommoditySettlementPeriodsNotionalQuantitySchedule  ***********************/
	class CommoditySettlementPeriodsNotionalQuantityScheduleBuilderImpl implements CommoditySettlementPeriodsNotionalQuantitySchedule.CommoditySettlementPeriodsNotionalQuantityScheduleBuilder {
	
		protected List<CommodityNotionalQuantity.CommodityNotionalQuantityBuilder> settlementPeriodsNotionalQuantityStep = new ArrayList<>();
		protected List<SettlementPeriodsReference.SettlementPeriodsReferenceBuilder> settlementPeriodsReference = new ArrayList<>();
	
		public CommoditySettlementPeriodsNotionalQuantityScheduleBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("settlementPeriodsNotionalQuantityStep")
		public List<? extends CommodityNotionalQuantity.CommodityNotionalQuantityBuilder> getSettlementPeriodsNotionalQuantityStep() {
			return settlementPeriodsNotionalQuantityStep;
		}
		
		public CommodityNotionalQuantity.CommodityNotionalQuantityBuilder getOrCreateSettlementPeriodsNotionalQuantityStep(int _index) {
		
			if (settlementPeriodsNotionalQuantityStep==null) {
				this.settlementPeriodsNotionalQuantityStep = new ArrayList<>();
			}
			CommodityNotionalQuantity.CommodityNotionalQuantityBuilder result;
			return getIndex(settlementPeriodsNotionalQuantityStep, _index, () -> {
						CommodityNotionalQuantity.CommodityNotionalQuantityBuilder newSettlementPeriodsNotionalQuantityStep = CommodityNotionalQuantity.builder();
						return newSettlementPeriodsNotionalQuantityStep;
					});
		}
		
		@Override
		@RosettaAttribute("settlementPeriodsReference")
		public List<? extends SettlementPeriodsReference.SettlementPeriodsReferenceBuilder> getSettlementPeriodsReference() {
			return settlementPeriodsReference;
		}
		
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
		public CommoditySettlementPeriodsNotionalQuantitySchedule.CommoditySettlementPeriodsNotionalQuantityScheduleBuilder addSettlementPeriodsNotionalQuantityStep(CommodityNotionalQuantity settlementPeriodsNotionalQuantityStep) {
			if (settlementPeriodsNotionalQuantityStep!=null) this.settlementPeriodsNotionalQuantityStep.add(settlementPeriodsNotionalQuantityStep.toBuilder());
			return this;
		}
		
		@Override
		public CommoditySettlementPeriodsNotionalQuantitySchedule.CommoditySettlementPeriodsNotionalQuantityScheduleBuilder addSettlementPeriodsNotionalQuantityStep(CommodityNotionalQuantity settlementPeriodsNotionalQuantityStep, int _idx) {
			getIndex(this.settlementPeriodsNotionalQuantityStep, _idx, () -> settlementPeriodsNotionalQuantityStep.toBuilder());
			return this;
		}
		@Override 
		public CommoditySettlementPeriodsNotionalQuantitySchedule.CommoditySettlementPeriodsNotionalQuantityScheduleBuilder addSettlementPeriodsNotionalQuantityStep(List<? extends CommodityNotionalQuantity> settlementPeriodsNotionalQuantitySteps) {
			if (settlementPeriodsNotionalQuantitySteps != null) {
				for (CommodityNotionalQuantity toAdd : settlementPeriodsNotionalQuantitySteps) {
					this.settlementPeriodsNotionalQuantityStep.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("settlementPeriodsNotionalQuantityStep")
		public CommoditySettlementPeriodsNotionalQuantitySchedule.CommoditySettlementPeriodsNotionalQuantityScheduleBuilder setSettlementPeriodsNotionalQuantityStep(List<? extends CommodityNotionalQuantity> settlementPeriodsNotionalQuantitySteps) {
			if (settlementPeriodsNotionalQuantitySteps == null)  {
				this.settlementPeriodsNotionalQuantityStep = new ArrayList<>();
			}
			else {
				this.settlementPeriodsNotionalQuantityStep = settlementPeriodsNotionalQuantitySteps.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public CommoditySettlementPeriodsNotionalQuantitySchedule.CommoditySettlementPeriodsNotionalQuantityScheduleBuilder addSettlementPeriodsReference(SettlementPeriodsReference settlementPeriodsReference) {
			if (settlementPeriodsReference!=null) this.settlementPeriodsReference.add(settlementPeriodsReference.toBuilder());
			return this;
		}
		
		@Override
		public CommoditySettlementPeriodsNotionalQuantitySchedule.CommoditySettlementPeriodsNotionalQuantityScheduleBuilder addSettlementPeriodsReference(SettlementPeriodsReference settlementPeriodsReference, int _idx) {
			getIndex(this.settlementPeriodsReference, _idx, () -> settlementPeriodsReference.toBuilder());
			return this;
		}
		@Override 
		public CommoditySettlementPeriodsNotionalQuantitySchedule.CommoditySettlementPeriodsNotionalQuantityScheduleBuilder addSettlementPeriodsReference(List<? extends SettlementPeriodsReference> settlementPeriodsReferences) {
			if (settlementPeriodsReferences != null) {
				for (SettlementPeriodsReference toAdd : settlementPeriodsReferences) {
					this.settlementPeriodsReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("settlementPeriodsReference")
		public CommoditySettlementPeriodsNotionalQuantitySchedule.CommoditySettlementPeriodsNotionalQuantityScheduleBuilder setSettlementPeriodsReference(List<? extends SettlementPeriodsReference> settlementPeriodsReferences) {
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
		public CommoditySettlementPeriodsNotionalQuantitySchedule build() {
			return new CommoditySettlementPeriodsNotionalQuantitySchedule.CommoditySettlementPeriodsNotionalQuantityScheduleImpl(this);
		}
		
		@Override
		public CommoditySettlementPeriodsNotionalQuantitySchedule.CommoditySettlementPeriodsNotionalQuantityScheduleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommoditySettlementPeriodsNotionalQuantitySchedule.CommoditySettlementPeriodsNotionalQuantityScheduleBuilder prune() {
			settlementPeriodsNotionalQuantityStep = settlementPeriodsNotionalQuantityStep.stream().filter(b->b!=null).<CommodityNotionalQuantity.CommodityNotionalQuantityBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			settlementPeriodsReference = settlementPeriodsReference.stream().filter(b->b!=null).<SettlementPeriodsReference.SettlementPeriodsReferenceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSettlementPeriodsNotionalQuantityStep()!=null && getSettlementPeriodsNotionalQuantityStep().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getSettlementPeriodsReference()!=null && getSettlementPeriodsReference().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommoditySettlementPeriodsNotionalQuantitySchedule.CommoditySettlementPeriodsNotionalQuantityScheduleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommoditySettlementPeriodsNotionalQuantitySchedule.CommoditySettlementPeriodsNotionalQuantityScheduleBuilder o = (CommoditySettlementPeriodsNotionalQuantitySchedule.CommoditySettlementPeriodsNotionalQuantityScheduleBuilder) other;
			
			merger.mergeRosetta(getSettlementPeriodsNotionalQuantityStep(), o.getSettlementPeriodsNotionalQuantityStep(), this::getOrCreateSettlementPeriodsNotionalQuantityStep);
			merger.mergeRosetta(getSettlementPeriodsReference(), o.getSettlementPeriodsReference(), this::getOrCreateSettlementPeriodsReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommoditySettlementPeriodsNotionalQuantitySchedule _that = getType().cast(o);
		
			if (!ListEquals.listEquals(settlementPeriodsNotionalQuantityStep, _that.getSettlementPeriodsNotionalQuantityStep())) return false;
			if (!ListEquals.listEquals(settlementPeriodsReference, _that.getSettlementPeriodsReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (settlementPeriodsNotionalQuantityStep != null ? settlementPeriodsNotionalQuantityStep.hashCode() : 0);
			_result = 31 * _result + (settlementPeriodsReference != null ? settlementPeriodsReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommoditySettlementPeriodsNotionalQuantityScheduleBuilder {" +
				"settlementPeriodsNotionalQuantityStep=" + this.settlementPeriodsNotionalQuantityStep + ", " +
				"settlementPeriodsReference=" + this.settlementPeriodsReference +
			'}';
		}
	}
}
