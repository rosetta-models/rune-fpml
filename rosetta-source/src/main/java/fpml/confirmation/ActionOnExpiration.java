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
import fpml.confirmation.ActionOnExpiration;
import fpml.confirmation.ActionOnExpiration.ActionOnExpirationBuilder;
import fpml.confirmation.ActionOnExpiration.ActionOnExpirationBuilderImpl;
import fpml.confirmation.ActionOnExpiration.ActionOnExpirationImpl;
import fpml.confirmation.OptionExerciseAmountModel;
import fpml.confirmation.meta.ActionOnExpirationMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="ActionOnExpiration", builder=ActionOnExpiration.ActionOnExpirationBuilderImpl.class, version="${project.version}")
public interface ActionOnExpiration extends RosettaModelObject {

	ActionOnExpirationMeta metaData = new ActionOnExpirationMeta();

	/*********************** Getter Methods  ***********************/
	OptionExerciseAmountModel getOptionExerciseAmountModel();

	/*********************** Build Methods  ***********************/
	ActionOnExpiration build();
	
	ActionOnExpiration.ActionOnExpirationBuilder toBuilder();
	
	static ActionOnExpiration.ActionOnExpirationBuilder builder() {
		return new ActionOnExpiration.ActionOnExpirationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ActionOnExpiration> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ActionOnExpiration> getType() {
		return ActionOnExpiration.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("optionExerciseAmountModel"), processor, OptionExerciseAmountModel.class, getOptionExerciseAmountModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ActionOnExpirationBuilder extends ActionOnExpiration, RosettaModelObjectBuilder {
		OptionExerciseAmountModel.OptionExerciseAmountModelBuilder getOrCreateOptionExerciseAmountModel();
		OptionExerciseAmountModel.OptionExerciseAmountModelBuilder getOptionExerciseAmountModel();
		ActionOnExpiration.ActionOnExpirationBuilder setOptionExerciseAmountModel(OptionExerciseAmountModel optionExerciseAmountModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("optionExerciseAmountModel"), processor, OptionExerciseAmountModel.OptionExerciseAmountModelBuilder.class, getOptionExerciseAmountModel());
		}
		

		ActionOnExpiration.ActionOnExpirationBuilder prune();
	}

	/*********************** Immutable Implementation of ActionOnExpiration  ***********************/
	class ActionOnExpirationImpl implements ActionOnExpiration {
		private final OptionExerciseAmountModel optionExerciseAmountModel;
		
		protected ActionOnExpirationImpl(ActionOnExpiration.ActionOnExpirationBuilder builder) {
			this.optionExerciseAmountModel = ofNullable(builder.getOptionExerciseAmountModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("optionExerciseAmountModel")
		public OptionExerciseAmountModel getOptionExerciseAmountModel() {
			return optionExerciseAmountModel;
		}
		
		@Override
		public ActionOnExpiration build() {
			return this;
		}
		
		@Override
		public ActionOnExpiration.ActionOnExpirationBuilder toBuilder() {
			ActionOnExpiration.ActionOnExpirationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ActionOnExpiration.ActionOnExpirationBuilder builder) {
			ofNullable(getOptionExerciseAmountModel()).ifPresent(builder::setOptionExerciseAmountModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ActionOnExpiration _that = getType().cast(o);
		
			if (!Objects.equals(optionExerciseAmountModel, _that.getOptionExerciseAmountModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (optionExerciseAmountModel != null ? optionExerciseAmountModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ActionOnExpiration {" +
				"optionExerciseAmountModel=" + this.optionExerciseAmountModel +
			'}';
		}
	}

	/*********************** Builder Implementation of ActionOnExpiration  ***********************/
	class ActionOnExpirationBuilderImpl implements ActionOnExpiration.ActionOnExpirationBuilder {
	
		protected OptionExerciseAmountModel.OptionExerciseAmountModelBuilder optionExerciseAmountModel;
	
		public ActionOnExpirationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("optionExerciseAmountModel")
		public OptionExerciseAmountModel.OptionExerciseAmountModelBuilder getOptionExerciseAmountModel() {
			return optionExerciseAmountModel;
		}
		
		@Override
		public OptionExerciseAmountModel.OptionExerciseAmountModelBuilder getOrCreateOptionExerciseAmountModel() {
			OptionExerciseAmountModel.OptionExerciseAmountModelBuilder result;
			if (optionExerciseAmountModel!=null) {
				result = optionExerciseAmountModel;
			}
			else {
				result = optionExerciseAmountModel = OptionExerciseAmountModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("optionExerciseAmountModel")
		public ActionOnExpiration.ActionOnExpirationBuilder setOptionExerciseAmountModel(OptionExerciseAmountModel optionExerciseAmountModel) {
			this.optionExerciseAmountModel = optionExerciseAmountModel==null?null:optionExerciseAmountModel.toBuilder();
			return this;
		}
		
		@Override
		public ActionOnExpiration build() {
			return new ActionOnExpiration.ActionOnExpirationImpl(this);
		}
		
		@Override
		public ActionOnExpiration.ActionOnExpirationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ActionOnExpiration.ActionOnExpirationBuilder prune() {
			if (optionExerciseAmountModel!=null && !optionExerciseAmountModel.prune().hasData()) optionExerciseAmountModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getOptionExerciseAmountModel()!=null && getOptionExerciseAmountModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ActionOnExpiration.ActionOnExpirationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ActionOnExpiration.ActionOnExpirationBuilder o = (ActionOnExpiration.ActionOnExpirationBuilder) other;
			
			merger.mergeRosetta(getOptionExerciseAmountModel(), o.getOptionExerciseAmountModel(), this::setOptionExerciseAmountModel);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ActionOnExpiration _that = getType().cast(o);
		
			if (!Objects.equals(optionExerciseAmountModel, _that.getOptionExerciseAmountModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (optionExerciseAmountModel != null ? optionExerciseAmountModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ActionOnExpirationBuilder {" +
				"optionExerciseAmountModel=" + this.optionExerciseAmountModel +
			'}';
		}
	}
}
