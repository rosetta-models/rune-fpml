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
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.EquityEuropeanExercise;
import fpml.confirmation.EquityEuropeanExercise.EquityEuropeanExerciseBuilder;
import fpml.confirmation.EquityEuropeanExercise.EquityEuropeanExerciseBuilderImpl;
import fpml.confirmation.EquityEuropeanExercise.EquityEuropeanExerciseImpl;
import fpml.confirmation.EquityExpirationModel;
import fpml.confirmation.Exercise;
import fpml.confirmation.Exercise.ExerciseBuilder;
import fpml.confirmation.Exercise.ExerciseBuilderImpl;
import fpml.confirmation.Exercise.ExerciseImpl;
import fpml.confirmation.meta.EquityEuropeanExerciseMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type for defining exercise procedures associated with a European style exercise of an equity option.
 * @version ${project.version}
 */
@RosettaDataType(value="EquityEuropeanExercise", builder=EquityEuropeanExercise.EquityEuropeanExerciseBuilderImpl.class, version="${project.version}")
public interface EquityEuropeanExercise extends Exercise {

	EquityEuropeanExerciseMeta metaData = new EquityEuropeanExerciseMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The last day within an exercise period for an American style option. For a European style option it is the only day within the exercise period.
	 */
	AdjustableOrRelativeDate getExpirationDate();
	EquityExpirationModel getEquityExpirationModel();

	/*********************** Build Methods  ***********************/
	EquityEuropeanExercise build();
	
	EquityEuropeanExercise.EquityEuropeanExerciseBuilder toBuilder();
	
	static EquityEuropeanExercise.EquityEuropeanExerciseBuilder builder() {
		return new EquityEuropeanExercise.EquityEuropeanExerciseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EquityEuropeanExercise> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends EquityEuropeanExercise> getType() {
		return EquityEuropeanExercise.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("expirationDate"), processor, AdjustableOrRelativeDate.class, getExpirationDate());
		processRosetta(path.newSubPath("equityExpirationModel"), processor, EquityExpirationModel.class, getEquityExpirationModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface EquityEuropeanExerciseBuilder extends EquityEuropeanExercise, Exercise.ExerciseBuilder {
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateExpirationDate();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getExpirationDate();
		EquityExpirationModel.EquityExpirationModelBuilder getOrCreateEquityExpirationModel();
		EquityExpirationModel.EquityExpirationModelBuilder getEquityExpirationModel();
		EquityEuropeanExercise.EquityEuropeanExerciseBuilder setId(String id);
		EquityEuropeanExercise.EquityEuropeanExerciseBuilder setExpirationDate(AdjustableOrRelativeDate expirationDate);
		EquityEuropeanExercise.EquityEuropeanExerciseBuilder setEquityExpirationModel(EquityExpirationModel equityExpirationModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("expirationDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getExpirationDate());
			processRosetta(path.newSubPath("equityExpirationModel"), processor, EquityExpirationModel.EquityExpirationModelBuilder.class, getEquityExpirationModel());
		}
		

		EquityEuropeanExercise.EquityEuropeanExerciseBuilder prune();
	}

	/*********************** Immutable Implementation of EquityEuropeanExercise  ***********************/
	class EquityEuropeanExerciseImpl extends Exercise.ExerciseImpl implements EquityEuropeanExercise {
		private final AdjustableOrRelativeDate expirationDate;
		private final EquityExpirationModel equityExpirationModel;
		
		protected EquityEuropeanExerciseImpl(EquityEuropeanExercise.EquityEuropeanExerciseBuilder builder) {
			super(builder);
			this.expirationDate = ofNullable(builder.getExpirationDate()).map(f->f.build()).orElse(null);
			this.equityExpirationModel = ofNullable(builder.getEquityExpirationModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("expirationDate")
		public AdjustableOrRelativeDate getExpirationDate() {
			return expirationDate;
		}
		
		@Override
		@RosettaAttribute("equityExpirationModel")
		public EquityExpirationModel getEquityExpirationModel() {
			return equityExpirationModel;
		}
		
		@Override
		public EquityEuropeanExercise build() {
			return this;
		}
		
		@Override
		public EquityEuropeanExercise.EquityEuropeanExerciseBuilder toBuilder() {
			EquityEuropeanExercise.EquityEuropeanExerciseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EquityEuropeanExercise.EquityEuropeanExerciseBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getExpirationDate()).ifPresent(builder::setExpirationDate);
			ofNullable(getEquityExpirationModel()).ifPresent(builder::setEquityExpirationModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			EquityEuropeanExercise _that = getType().cast(o);
		
			if (!Objects.equals(expirationDate, _that.getExpirationDate())) return false;
			if (!Objects.equals(equityExpirationModel, _that.getEquityExpirationModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (expirationDate != null ? expirationDate.hashCode() : 0);
			_result = 31 * _result + (equityExpirationModel != null ? equityExpirationModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EquityEuropeanExercise {" +
				"expirationDate=" + this.expirationDate + ", " +
				"equityExpirationModel=" + this.equityExpirationModel +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of EquityEuropeanExercise  ***********************/
	class EquityEuropeanExerciseBuilderImpl extends Exercise.ExerciseBuilderImpl  implements EquityEuropeanExercise.EquityEuropeanExerciseBuilder {
	
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder expirationDate;
		protected EquityExpirationModel.EquityExpirationModelBuilder equityExpirationModel;
	
		public EquityEuropeanExerciseBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("expirationDate")
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getExpirationDate() {
			return expirationDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateExpirationDate() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			if (expirationDate!=null) {
				result = expirationDate;
			}
			else {
				result = expirationDate = AdjustableOrRelativeDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("equityExpirationModel")
		public EquityExpirationModel.EquityExpirationModelBuilder getEquityExpirationModel() {
			return equityExpirationModel;
		}
		
		@Override
		public EquityExpirationModel.EquityExpirationModelBuilder getOrCreateEquityExpirationModel() {
			EquityExpirationModel.EquityExpirationModelBuilder result;
			if (equityExpirationModel!=null) {
				result = equityExpirationModel;
			}
			else {
				result = equityExpirationModel = EquityExpirationModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public EquityEuropeanExercise.EquityEuropeanExerciseBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("expirationDate")
		public EquityEuropeanExercise.EquityEuropeanExerciseBuilder setExpirationDate(AdjustableOrRelativeDate expirationDate) {
			this.expirationDate = expirationDate==null?null:expirationDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("equityExpirationModel")
		public EquityEuropeanExercise.EquityEuropeanExerciseBuilder setEquityExpirationModel(EquityExpirationModel equityExpirationModel) {
			this.equityExpirationModel = equityExpirationModel==null?null:equityExpirationModel.toBuilder();
			return this;
		}
		
		@Override
		public EquityEuropeanExercise build() {
			return new EquityEuropeanExercise.EquityEuropeanExerciseImpl(this);
		}
		
		@Override
		public EquityEuropeanExercise.EquityEuropeanExerciseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EquityEuropeanExercise.EquityEuropeanExerciseBuilder prune() {
			super.prune();
			if (expirationDate!=null && !expirationDate.prune().hasData()) expirationDate = null;
			if (equityExpirationModel!=null && !equityExpirationModel.prune().hasData()) equityExpirationModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getExpirationDate()!=null && getExpirationDate().hasData()) return true;
			if (getEquityExpirationModel()!=null && getEquityExpirationModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EquityEuropeanExercise.EquityEuropeanExerciseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			EquityEuropeanExercise.EquityEuropeanExerciseBuilder o = (EquityEuropeanExercise.EquityEuropeanExerciseBuilder) other;
			
			merger.mergeRosetta(getExpirationDate(), o.getExpirationDate(), this::setExpirationDate);
			merger.mergeRosetta(getEquityExpirationModel(), o.getEquityExpirationModel(), this::setEquityExpirationModel);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			EquityEuropeanExercise _that = getType().cast(o);
		
			if (!Objects.equals(expirationDate, _that.getExpirationDate())) return false;
			if (!Objects.equals(equityExpirationModel, _that.getEquityExpirationModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (expirationDate != null ? expirationDate.hashCode() : 0);
			_result = 31 * _result + (equityExpirationModel != null ? equityExpirationModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EquityEuropeanExerciseBuilder {" +
				"expirationDate=" + this.expirationDate + ", " +
				"equityExpirationModel=" + this.equityExpirationModel +
			'}' + " " + super.toString();
		}
	}
}
