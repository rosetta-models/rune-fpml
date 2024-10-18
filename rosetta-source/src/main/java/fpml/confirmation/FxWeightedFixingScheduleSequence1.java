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
import fpml.confirmation.FxFixingObservation;
import fpml.confirmation.FxWeightedFixingScheduleSequence1;
import fpml.confirmation.FxWeightedFixingScheduleSequence1.FxWeightedFixingScheduleSequence1Builder;
import fpml.confirmation.FxWeightedFixingScheduleSequence1.FxWeightedFixingScheduleSequence1BuilderImpl;
import fpml.confirmation.FxWeightedFixingScheduleSequence1.FxWeightedFixingScheduleSequence1Impl;
import fpml.confirmation.ParametricScheduleModel;
import fpml.confirmation.meta.FxWeightedFixingScheduleSequence1Meta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="FxWeightedFixingScheduleSequence1", builder=FxWeightedFixingScheduleSequence1.FxWeightedFixingScheduleSequence1BuilderImpl.class, version="${project.version}")
public interface FxWeightedFixingScheduleSequence1 extends RosettaModelObject {

	FxWeightedFixingScheduleSequence1Meta metaData = new FxWeightedFixingScheduleSequence1Meta();

	/*********************** Getter Methods  ***********************/
	ParametricScheduleModel getParametricScheduleModel();
	/**
	 * The number of fixing points in the fixing schedule.
	 */
	Integer getNumberOfFixings();
	/**
	 * An explicit list of dates in the schedule. Where a conflict every existed between parametric and explicit dates, the explicit list of dates would takes precedence.
	 */
	List<? extends FxFixingObservation> getFixing();

	/*********************** Build Methods  ***********************/
	FxWeightedFixingScheduleSequence1 build();
	
	FxWeightedFixingScheduleSequence1.FxWeightedFixingScheduleSequence1Builder toBuilder();
	
	static FxWeightedFixingScheduleSequence1.FxWeightedFixingScheduleSequence1Builder builder() {
		return new FxWeightedFixingScheduleSequence1.FxWeightedFixingScheduleSequence1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxWeightedFixingScheduleSequence1> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxWeightedFixingScheduleSequence1> getType() {
		return FxWeightedFixingScheduleSequence1.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("parametricScheduleModel"), processor, ParametricScheduleModel.class, getParametricScheduleModel());
		processor.processBasic(path.newSubPath("numberOfFixings"), Integer.class, getNumberOfFixings(), this);
		processRosetta(path.newSubPath("fixing"), processor, FxFixingObservation.class, getFixing());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxWeightedFixingScheduleSequence1Builder extends FxWeightedFixingScheduleSequence1, RosettaModelObjectBuilder {
		ParametricScheduleModel.ParametricScheduleModelBuilder getOrCreateParametricScheduleModel();
		ParametricScheduleModel.ParametricScheduleModelBuilder getParametricScheduleModel();
		FxFixingObservation.FxFixingObservationBuilder getOrCreateFixing(int _index);
		List<? extends FxFixingObservation.FxFixingObservationBuilder> getFixing();
		FxWeightedFixingScheduleSequence1.FxWeightedFixingScheduleSequence1Builder setParametricScheduleModel(ParametricScheduleModel parametricScheduleModel);
		FxWeightedFixingScheduleSequence1.FxWeightedFixingScheduleSequence1Builder setNumberOfFixings(Integer numberOfFixings);
		FxWeightedFixingScheduleSequence1.FxWeightedFixingScheduleSequence1Builder addFixing(FxFixingObservation fixing0);
		FxWeightedFixingScheduleSequence1.FxWeightedFixingScheduleSequence1Builder addFixing(FxFixingObservation fixing1, int _idx);
		FxWeightedFixingScheduleSequence1.FxWeightedFixingScheduleSequence1Builder addFixing(List<? extends FxFixingObservation> fixing2);
		FxWeightedFixingScheduleSequence1.FxWeightedFixingScheduleSequence1Builder setFixing(List<? extends FxFixingObservation> fixing3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("parametricScheduleModel"), processor, ParametricScheduleModel.ParametricScheduleModelBuilder.class, getParametricScheduleModel());
			processor.processBasic(path.newSubPath("numberOfFixings"), Integer.class, getNumberOfFixings(), this);
			processRosetta(path.newSubPath("fixing"), processor, FxFixingObservation.FxFixingObservationBuilder.class, getFixing());
		}
		

		FxWeightedFixingScheduleSequence1.FxWeightedFixingScheduleSequence1Builder prune();
	}

	/*********************** Immutable Implementation of FxWeightedFixingScheduleSequence1  ***********************/
	class FxWeightedFixingScheduleSequence1Impl implements FxWeightedFixingScheduleSequence1 {
		private final ParametricScheduleModel parametricScheduleModel;
		private final Integer numberOfFixings;
		private final List<? extends FxFixingObservation> fixing;
		
		protected FxWeightedFixingScheduleSequence1Impl(FxWeightedFixingScheduleSequence1.FxWeightedFixingScheduleSequence1Builder builder) {
			this.parametricScheduleModel = ofNullable(builder.getParametricScheduleModel()).map(f->f.build()).orElse(null);
			this.numberOfFixings = builder.getNumberOfFixings();
			this.fixing = ofNullable(builder.getFixing()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("parametricScheduleModel")
		public ParametricScheduleModel getParametricScheduleModel() {
			return parametricScheduleModel;
		}
		
		@Override
		@RosettaAttribute("numberOfFixings")
		public Integer getNumberOfFixings() {
			return numberOfFixings;
		}
		
		@Override
		@RosettaAttribute("fixing")
		public List<? extends FxFixingObservation> getFixing() {
			return fixing;
		}
		
		@Override
		public FxWeightedFixingScheduleSequence1 build() {
			return this;
		}
		
		@Override
		public FxWeightedFixingScheduleSequence1.FxWeightedFixingScheduleSequence1Builder toBuilder() {
			FxWeightedFixingScheduleSequence1.FxWeightedFixingScheduleSequence1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxWeightedFixingScheduleSequence1.FxWeightedFixingScheduleSequence1Builder builder) {
			ofNullable(getParametricScheduleModel()).ifPresent(builder::setParametricScheduleModel);
			ofNullable(getNumberOfFixings()).ifPresent(builder::setNumberOfFixings);
			ofNullable(getFixing()).ifPresent(builder::setFixing);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxWeightedFixingScheduleSequence1 _that = getType().cast(o);
		
			if (!Objects.equals(parametricScheduleModel, _that.getParametricScheduleModel())) return false;
			if (!Objects.equals(numberOfFixings, _that.getNumberOfFixings())) return false;
			if (!ListEquals.listEquals(fixing, _that.getFixing())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (parametricScheduleModel != null ? parametricScheduleModel.hashCode() : 0);
			_result = 31 * _result + (numberOfFixings != null ? numberOfFixings.hashCode() : 0);
			_result = 31 * _result + (fixing != null ? fixing.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxWeightedFixingScheduleSequence1 {" +
				"parametricScheduleModel=" + this.parametricScheduleModel + ", " +
				"numberOfFixings=" + this.numberOfFixings + ", " +
				"fixing=" + this.fixing +
			'}';
		}
	}

	/*********************** Builder Implementation of FxWeightedFixingScheduleSequence1  ***********************/
	class FxWeightedFixingScheduleSequence1BuilderImpl implements FxWeightedFixingScheduleSequence1.FxWeightedFixingScheduleSequence1Builder {
	
		protected ParametricScheduleModel.ParametricScheduleModelBuilder parametricScheduleModel;
		protected Integer numberOfFixings;
		protected List<FxFixingObservation.FxFixingObservationBuilder> fixing = new ArrayList<>();
	
		public FxWeightedFixingScheduleSequence1BuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("parametricScheduleModel")
		public ParametricScheduleModel.ParametricScheduleModelBuilder getParametricScheduleModel() {
			return parametricScheduleModel;
		}
		
		@Override
		public ParametricScheduleModel.ParametricScheduleModelBuilder getOrCreateParametricScheduleModel() {
			ParametricScheduleModel.ParametricScheduleModelBuilder result;
			if (parametricScheduleModel!=null) {
				result = parametricScheduleModel;
			}
			else {
				result = parametricScheduleModel = ParametricScheduleModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("numberOfFixings")
		public Integer getNumberOfFixings() {
			return numberOfFixings;
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
		@RosettaAttribute("parametricScheduleModel")
		public FxWeightedFixingScheduleSequence1.FxWeightedFixingScheduleSequence1Builder setParametricScheduleModel(ParametricScheduleModel parametricScheduleModel) {
			this.parametricScheduleModel = parametricScheduleModel==null?null:parametricScheduleModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("numberOfFixings")
		public FxWeightedFixingScheduleSequence1.FxWeightedFixingScheduleSequence1Builder setNumberOfFixings(Integer numberOfFixings) {
			this.numberOfFixings = numberOfFixings==null?null:numberOfFixings;
			return this;
		}
		@Override
		@RosettaAttribute("fixing")
		public FxWeightedFixingScheduleSequence1.FxWeightedFixingScheduleSequence1Builder addFixing(FxFixingObservation fixing) {
			if (fixing!=null) this.fixing.add(fixing.toBuilder());
			return this;
		}
		
		@Override
		public FxWeightedFixingScheduleSequence1.FxWeightedFixingScheduleSequence1Builder addFixing(FxFixingObservation fixing, int _idx) {
			getIndex(this.fixing, _idx, () -> fixing.toBuilder());
			return this;
		}
		@Override 
		public FxWeightedFixingScheduleSequence1.FxWeightedFixingScheduleSequence1Builder addFixing(List<? extends FxFixingObservation> fixings) {
			if (fixings != null) {
				for (FxFixingObservation toAdd : fixings) {
					this.fixing.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public FxWeightedFixingScheduleSequence1.FxWeightedFixingScheduleSequence1Builder setFixing(List<? extends FxFixingObservation> fixings) {
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
		public FxWeightedFixingScheduleSequence1 build() {
			return new FxWeightedFixingScheduleSequence1.FxWeightedFixingScheduleSequence1Impl(this);
		}
		
		@Override
		public FxWeightedFixingScheduleSequence1.FxWeightedFixingScheduleSequence1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxWeightedFixingScheduleSequence1.FxWeightedFixingScheduleSequence1Builder prune() {
			if (parametricScheduleModel!=null && !parametricScheduleModel.prune().hasData()) parametricScheduleModel = null;
			fixing = fixing.stream().filter(b->b!=null).<FxFixingObservation.FxFixingObservationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getParametricScheduleModel()!=null && getParametricScheduleModel().hasData()) return true;
			if (getNumberOfFixings()!=null) return true;
			if (getFixing()!=null && getFixing().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxWeightedFixingScheduleSequence1.FxWeightedFixingScheduleSequence1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxWeightedFixingScheduleSequence1.FxWeightedFixingScheduleSequence1Builder o = (FxWeightedFixingScheduleSequence1.FxWeightedFixingScheduleSequence1Builder) other;
			
			merger.mergeRosetta(getParametricScheduleModel(), o.getParametricScheduleModel(), this::setParametricScheduleModel);
			merger.mergeRosetta(getFixing(), o.getFixing(), this::getOrCreateFixing);
			
			merger.mergeBasic(getNumberOfFixings(), o.getNumberOfFixings(), this::setNumberOfFixings);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxWeightedFixingScheduleSequence1 _that = getType().cast(o);
		
			if (!Objects.equals(parametricScheduleModel, _that.getParametricScheduleModel())) return false;
			if (!Objects.equals(numberOfFixings, _that.getNumberOfFixings())) return false;
			if (!ListEquals.listEquals(fixing, _that.getFixing())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (parametricScheduleModel != null ? parametricScheduleModel.hashCode() : 0);
			_result = 31 * _result + (numberOfFixings != null ? numberOfFixings.hashCode() : 0);
			_result = 31 * _result + (fixing != null ? fixing.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxWeightedFixingScheduleSequence1Builder {" +
				"parametricScheduleModel=" + this.parametricScheduleModel + ", " +
				"numberOfFixings=" + this.numberOfFixings + ", " +
				"fixing=" + this.fixing +
			'}';
		}
	}
}
