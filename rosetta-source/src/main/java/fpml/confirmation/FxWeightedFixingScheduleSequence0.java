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
import fpml.confirmation.BusinessDayAdjustments;
import fpml.confirmation.FxFixingObservation;
import fpml.confirmation.FxWeightedFixingScheduleSequence0;
import fpml.confirmation.FxWeightedFixingScheduleSequence0.FxWeightedFixingScheduleSequence0Builder;
import fpml.confirmation.FxWeightedFixingScheduleSequence0.FxWeightedFixingScheduleSequence0BuilderImpl;
import fpml.confirmation.FxWeightedFixingScheduleSequence0.FxWeightedFixingScheduleSequence0Impl;
import fpml.confirmation.meta.FxWeightedFixingScheduleSequence0Meta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="FxWeightedFixingScheduleSequence0", builder=FxWeightedFixingScheduleSequence0.FxWeightedFixingScheduleSequence0BuilderImpl.class, version="${project.version}")
public interface FxWeightedFixingScheduleSequence0 extends RosettaModelObject {

	FxWeightedFixingScheduleSequence0Meta metaData = new FxWeightedFixingScheduleSequence0Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Date adjustments applied to the adjusted dates including the business day convention and the business centers.
	 */
	BusinessDayAdjustments getDateAdjustments();
	/**
	 * List of schedule dates. These dates have been subject to adjustments based on the dateAdjustments structure.
	 */
	List<? extends FxFixingObservation> getFixing();

	/*********************** Build Methods  ***********************/
	FxWeightedFixingScheduleSequence0 build();
	
	FxWeightedFixingScheduleSequence0.FxWeightedFixingScheduleSequence0Builder toBuilder();
	
	static FxWeightedFixingScheduleSequence0.FxWeightedFixingScheduleSequence0Builder builder() {
		return new FxWeightedFixingScheduleSequence0.FxWeightedFixingScheduleSequence0BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxWeightedFixingScheduleSequence0> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxWeightedFixingScheduleSequence0> getType() {
		return FxWeightedFixingScheduleSequence0.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("dateAdjustments"), processor, BusinessDayAdjustments.class, getDateAdjustments());
		processRosetta(path.newSubPath("fixing"), processor, FxFixingObservation.class, getFixing());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxWeightedFixingScheduleSequence0Builder extends FxWeightedFixingScheduleSequence0, RosettaModelObjectBuilder {
		BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getOrCreateDateAdjustments();
		BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getDateAdjustments();
		FxFixingObservation.FxFixingObservationBuilder getOrCreateFixing(int _index);
		List<? extends FxFixingObservation.FxFixingObservationBuilder> getFixing();
		FxWeightedFixingScheduleSequence0.FxWeightedFixingScheduleSequence0Builder setDateAdjustments(BusinessDayAdjustments dateAdjustments);
		FxWeightedFixingScheduleSequence0.FxWeightedFixingScheduleSequence0Builder addFixing(FxFixingObservation fixing0);
		FxWeightedFixingScheduleSequence0.FxWeightedFixingScheduleSequence0Builder addFixing(FxFixingObservation fixing1, int _idx);
		FxWeightedFixingScheduleSequence0.FxWeightedFixingScheduleSequence0Builder addFixing(List<? extends FxFixingObservation> fixing2);
		FxWeightedFixingScheduleSequence0.FxWeightedFixingScheduleSequence0Builder setFixing(List<? extends FxFixingObservation> fixing3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("dateAdjustments"), processor, BusinessDayAdjustments.BusinessDayAdjustmentsBuilder.class, getDateAdjustments());
			processRosetta(path.newSubPath("fixing"), processor, FxFixingObservation.FxFixingObservationBuilder.class, getFixing());
		}
		

		FxWeightedFixingScheduleSequence0.FxWeightedFixingScheduleSequence0Builder prune();
	}

	/*********************** Immutable Implementation of FxWeightedFixingScheduleSequence0  ***********************/
	class FxWeightedFixingScheduleSequence0Impl implements FxWeightedFixingScheduleSequence0 {
		private final BusinessDayAdjustments dateAdjustments;
		private final List<? extends FxFixingObservation> fixing;
		
		protected FxWeightedFixingScheduleSequence0Impl(FxWeightedFixingScheduleSequence0.FxWeightedFixingScheduleSequence0Builder builder) {
			this.dateAdjustments = ofNullable(builder.getDateAdjustments()).map(f->f.build()).orElse(null);
			this.fixing = ofNullable(builder.getFixing()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("dateAdjustments")
		public BusinessDayAdjustments getDateAdjustments() {
			return dateAdjustments;
		}
		
		@Override
		@RosettaAttribute("fixing")
		public List<? extends FxFixingObservation> getFixing() {
			return fixing;
		}
		
		@Override
		public FxWeightedFixingScheduleSequence0 build() {
			return this;
		}
		
		@Override
		public FxWeightedFixingScheduleSequence0.FxWeightedFixingScheduleSequence0Builder toBuilder() {
			FxWeightedFixingScheduleSequence0.FxWeightedFixingScheduleSequence0Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxWeightedFixingScheduleSequence0.FxWeightedFixingScheduleSequence0Builder builder) {
			ofNullable(getDateAdjustments()).ifPresent(builder::setDateAdjustments);
			ofNullable(getFixing()).ifPresent(builder::setFixing);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxWeightedFixingScheduleSequence0 _that = getType().cast(o);
		
			if (!Objects.equals(dateAdjustments, _that.getDateAdjustments())) return false;
			if (!ListEquals.listEquals(fixing, _that.getFixing())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dateAdjustments != null ? dateAdjustments.hashCode() : 0);
			_result = 31 * _result + (fixing != null ? fixing.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxWeightedFixingScheduleSequence0 {" +
				"dateAdjustments=" + this.dateAdjustments + ", " +
				"fixing=" + this.fixing +
			'}';
		}
	}

	/*********************** Builder Implementation of FxWeightedFixingScheduleSequence0  ***********************/
	class FxWeightedFixingScheduleSequence0BuilderImpl implements FxWeightedFixingScheduleSequence0.FxWeightedFixingScheduleSequence0Builder {
	
		protected BusinessDayAdjustments.BusinessDayAdjustmentsBuilder dateAdjustments;
		protected List<FxFixingObservation.FxFixingObservationBuilder> fixing = new ArrayList<>();
	
		public FxWeightedFixingScheduleSequence0BuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("dateAdjustments")
		public BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getDateAdjustments() {
			return dateAdjustments;
		}
		
		@Override
		public BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getOrCreateDateAdjustments() {
			BusinessDayAdjustments.BusinessDayAdjustmentsBuilder result;
			if (dateAdjustments!=null) {
				result = dateAdjustments;
			}
			else {
				result = dateAdjustments = BusinessDayAdjustments.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fixing")
		public List<? extends FxFixingObservation.FxFixingObservationBuilder> getFixing() {
			return fixing;
		}
		
		@Override
		public FxFixingObservation.FxFixingObservationBuilder getOrCreateFixing(int _index) {
		
			if (fixing==null) {
				this.fixing = new ArrayList<>();
			}
			FxFixingObservation.FxFixingObservationBuilder result;
			return getIndex(fixing, _index, () -> {
						FxFixingObservation.FxFixingObservationBuilder newFixing = FxFixingObservation.builder();
						return newFixing;
					});
		}
		
		@Override
		@RosettaAttribute("dateAdjustments")
		public FxWeightedFixingScheduleSequence0.FxWeightedFixingScheduleSequence0Builder setDateAdjustments(BusinessDayAdjustments dateAdjustments) {
			this.dateAdjustments = dateAdjustments==null?null:dateAdjustments.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fixing")
		public FxWeightedFixingScheduleSequence0.FxWeightedFixingScheduleSequence0Builder addFixing(FxFixingObservation fixing) {
			if (fixing!=null) this.fixing.add(fixing.toBuilder());
			return this;
		}
		
		@Override
		public FxWeightedFixingScheduleSequence0.FxWeightedFixingScheduleSequence0Builder addFixing(FxFixingObservation fixing, int _idx) {
			getIndex(this.fixing, _idx, () -> fixing.toBuilder());
			return this;
		}
		@Override 
		public FxWeightedFixingScheduleSequence0.FxWeightedFixingScheduleSequence0Builder addFixing(List<? extends FxFixingObservation> fixings) {
			if (fixings != null) {
				for (FxFixingObservation toAdd : fixings) {
					this.fixing.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public FxWeightedFixingScheduleSequence0.FxWeightedFixingScheduleSequence0Builder setFixing(List<? extends FxFixingObservation> fixings) {
			if (fixings == null)  {
				this.fixing = new ArrayList<>();
			}
			else {
				this.fixing = fixings.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public FxWeightedFixingScheduleSequence0 build() {
			return new FxWeightedFixingScheduleSequence0.FxWeightedFixingScheduleSequence0Impl(this);
		}
		
		@Override
		public FxWeightedFixingScheduleSequence0.FxWeightedFixingScheduleSequence0Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxWeightedFixingScheduleSequence0.FxWeightedFixingScheduleSequence0Builder prune() {
			if (dateAdjustments!=null && !dateAdjustments.prune().hasData()) dateAdjustments = null;
			fixing = fixing.stream().filter(b->b!=null).<FxFixingObservation.FxFixingObservationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDateAdjustments()!=null && getDateAdjustments().hasData()) return true;
			if (getFixing()!=null && getFixing().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxWeightedFixingScheduleSequence0.FxWeightedFixingScheduleSequence0Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxWeightedFixingScheduleSequence0.FxWeightedFixingScheduleSequence0Builder o = (FxWeightedFixingScheduleSequence0.FxWeightedFixingScheduleSequence0Builder) other;
			
			merger.mergeRosetta(getDateAdjustments(), o.getDateAdjustments(), this::setDateAdjustments);
			merger.mergeRosetta(getFixing(), o.getFixing(), this::getOrCreateFixing);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxWeightedFixingScheduleSequence0 _that = getType().cast(o);
		
			if (!Objects.equals(dateAdjustments, _that.getDateAdjustments())) return false;
			if (!ListEquals.listEquals(fixing, _that.getFixing())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dateAdjustments != null ? dateAdjustments.hashCode() : 0);
			_result = 31 * _result + (fixing != null ? fixing.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxWeightedFixingScheduleSequence0Builder {" +
				"dateAdjustments=" + this.dateAdjustments + ", " +
				"fixing=" + this.fixing +
			'}';
		}
	}
}
