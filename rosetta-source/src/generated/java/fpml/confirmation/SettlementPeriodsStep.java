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
import fpml.confirmation.SettlementPeriodsReference;
import fpml.confirmation.SettlementPeriodsStep;
import fpml.confirmation.SettlementPeriodsStep.SettlementPeriodsStepBuilder;
import fpml.confirmation.SettlementPeriodsStep.SettlementPeriodsStepBuilderImpl;
import fpml.confirmation.SettlementPeriodsStep.SettlementPeriodsStepImpl;
import fpml.confirmation.meta.SettlementPeriodsStepMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A reference to the range of Settlement Periods that applies to a given period of a transaction.
 * @version ${project.version}
 */
@RosettaDataType(value="SettlementPeriodsStep", builder=SettlementPeriodsStep.SettlementPeriodsStepBuilderImpl.class, version="${project.version}")
public interface SettlementPeriodsStep extends RosettaModelObject {

	SettlementPeriodsStepMeta metaData = new SettlementPeriodsStepMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The specification of the Settlement Periods in which the electricity will be delivered. The Settlement Periods will apply for the duration of the appliable period. If more than one settlementPeriods element is present this indicates multiple ranges of Settlement Periods apply for the duration of the applicable period.
	 */
	List<? extends SettlementPeriodsReference> getSettlementPeriodsReference();

	/*********************** Build Methods  ***********************/
	SettlementPeriodsStep build();
	
	SettlementPeriodsStep.SettlementPeriodsStepBuilder toBuilder();
	
	static SettlementPeriodsStep.SettlementPeriodsStepBuilder builder() {
		return new SettlementPeriodsStep.SettlementPeriodsStepBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SettlementPeriodsStep> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends SettlementPeriodsStep> getType() {
		return SettlementPeriodsStep.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("settlementPeriodsReference"), processor, SettlementPeriodsReference.class, getSettlementPeriodsReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface SettlementPeriodsStepBuilder extends SettlementPeriodsStep, RosettaModelObjectBuilder {
		SettlementPeriodsReference.SettlementPeriodsReferenceBuilder getOrCreateSettlementPeriodsReference(int _index);
		List<? extends SettlementPeriodsReference.SettlementPeriodsReferenceBuilder> getSettlementPeriodsReference();
		SettlementPeriodsStep.SettlementPeriodsStepBuilder addSettlementPeriodsReference(SettlementPeriodsReference settlementPeriodsReference0);
		SettlementPeriodsStep.SettlementPeriodsStepBuilder addSettlementPeriodsReference(SettlementPeriodsReference settlementPeriodsReference1, int _idx);
		SettlementPeriodsStep.SettlementPeriodsStepBuilder addSettlementPeriodsReference(List<? extends SettlementPeriodsReference> settlementPeriodsReference2);
		SettlementPeriodsStep.SettlementPeriodsStepBuilder setSettlementPeriodsReference(List<? extends SettlementPeriodsReference> settlementPeriodsReference3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("settlementPeriodsReference"), processor, SettlementPeriodsReference.SettlementPeriodsReferenceBuilder.class, getSettlementPeriodsReference());
		}
		

		SettlementPeriodsStep.SettlementPeriodsStepBuilder prune();
	}

	/*********************** Immutable Implementation of SettlementPeriodsStep  ***********************/
	class SettlementPeriodsStepImpl implements SettlementPeriodsStep {
		private final List<? extends SettlementPeriodsReference> settlementPeriodsReference;
		
		protected SettlementPeriodsStepImpl(SettlementPeriodsStep.SettlementPeriodsStepBuilder builder) {
			this.settlementPeriodsReference = ofNullable(builder.getSettlementPeriodsReference()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("settlementPeriodsReference")
		public List<? extends SettlementPeriodsReference> getSettlementPeriodsReference() {
			return settlementPeriodsReference;
		}
		
		@Override
		public SettlementPeriodsStep build() {
			return this;
		}
		
		@Override
		public SettlementPeriodsStep.SettlementPeriodsStepBuilder toBuilder() {
			SettlementPeriodsStep.SettlementPeriodsStepBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SettlementPeriodsStep.SettlementPeriodsStepBuilder builder) {
			ofNullable(getSettlementPeriodsReference()).ifPresent(builder::setSettlementPeriodsReference);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SettlementPeriodsStep _that = getType().cast(o);
		
			if (!ListEquals.listEquals(settlementPeriodsReference, _that.getSettlementPeriodsReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (settlementPeriodsReference != null ? settlementPeriodsReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SettlementPeriodsStep {" +
				"settlementPeriodsReference=" + this.settlementPeriodsReference +
			'}';
		}
	}

	/*********************** Builder Implementation of SettlementPeriodsStep  ***********************/
	class SettlementPeriodsStepBuilderImpl implements SettlementPeriodsStep.SettlementPeriodsStepBuilder {
	
		protected List<SettlementPeriodsReference.SettlementPeriodsReferenceBuilder> settlementPeriodsReference = new ArrayList<>();
	
		public SettlementPeriodsStepBuilderImpl() {
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
		public SettlementPeriodsStep.SettlementPeriodsStepBuilder addSettlementPeriodsReference(SettlementPeriodsReference settlementPeriodsReference) {
			if (settlementPeriodsReference!=null) this.settlementPeriodsReference.add(settlementPeriodsReference.toBuilder());
			return this;
		}
		
		@Override
		public SettlementPeriodsStep.SettlementPeriodsStepBuilder addSettlementPeriodsReference(SettlementPeriodsReference settlementPeriodsReference, int _idx) {
			getIndex(this.settlementPeriodsReference, _idx, () -> settlementPeriodsReference.toBuilder());
			return this;
		}
		@Override 
		public SettlementPeriodsStep.SettlementPeriodsStepBuilder addSettlementPeriodsReference(List<? extends SettlementPeriodsReference> settlementPeriodsReferences) {
			if (settlementPeriodsReferences != null) {
				for (SettlementPeriodsReference toAdd : settlementPeriodsReferences) {
					this.settlementPeriodsReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("settlementPeriodsReference")
		public SettlementPeriodsStep.SettlementPeriodsStepBuilder setSettlementPeriodsReference(List<? extends SettlementPeriodsReference> settlementPeriodsReferences) {
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
		public SettlementPeriodsStep build() {
			return new SettlementPeriodsStep.SettlementPeriodsStepImpl(this);
		}
		
		@Override
		public SettlementPeriodsStep.SettlementPeriodsStepBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SettlementPeriodsStep.SettlementPeriodsStepBuilder prune() {
			settlementPeriodsReference = settlementPeriodsReference.stream().filter(b->b!=null).<SettlementPeriodsReference.SettlementPeriodsReferenceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSettlementPeriodsReference()!=null && getSettlementPeriodsReference().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SettlementPeriodsStep.SettlementPeriodsStepBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SettlementPeriodsStep.SettlementPeriodsStepBuilder o = (SettlementPeriodsStep.SettlementPeriodsStepBuilder) other;
			
			merger.mergeRosetta(getSettlementPeriodsReference(), o.getSettlementPeriodsReference(), this::getOrCreateSettlementPeriodsReference);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SettlementPeriodsStep _that = getType().cast(o);
		
			if (!ListEquals.listEquals(settlementPeriodsReference, _that.getSettlementPeriodsReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (settlementPeriodsReference != null ? settlementPeriodsReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SettlementPeriodsStepBuilder {" +
				"settlementPeriodsReference=" + this.settlementPeriodsReference +
			'}';
		}
	}
}
