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
import fpml.confirmation.ExerciseActionEnum;
import fpml.confirmation.OptionExerciseAmountModel;
import fpml.confirmation.OptionExerciseAmountModel.OptionExerciseAmountModelBuilder;
import fpml.confirmation.OptionExerciseAmountModel.OptionExerciseAmountModelBuilderImpl;
import fpml.confirmation.OptionExerciseAmountModel.OptionExerciseAmountModelImpl;
import fpml.confirmation.OptionExerciseAmountModelSequence0;
import fpml.confirmation.OptionExerciseAmountModelSequence1;
import fpml.confirmation.OptionExerciseAmountModelSequence2;
import fpml.confirmation.OptionExerciseAmounts;
import fpml.confirmation.meta.OptionExerciseAmountModelMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="OptionExerciseAmountModel", builder=OptionExerciseAmountModel.OptionExerciseAmountModelBuilderImpl.class, version="${project.version}")
public interface OptionExerciseAmountModel extends RosettaModelObject {

	OptionExerciseAmountModelMeta metaData = new OptionExerciseAmountModelMeta();

	/*********************** Getter Methods  ***********************/
	ExerciseActionEnum getExerciseAction();
	Boolean getExpiry();
	Boolean getFullExercise();
	OptionExerciseAmountModelSequence0 getOptionExerciseAmountModelSequence0();
	OptionExerciseAmountModelSequence1 getOptionExerciseAmountModelSequence1();
	OptionExerciseAmountModelSequence2 getOptionExerciseAmountModelSequence2();
	/**
	 * Specifies the Number of Units
	 */
	List<? extends OptionExerciseAmounts> getSpecifiedExercise();

	/*********************** Build Methods  ***********************/
	OptionExerciseAmountModel build();
	
	OptionExerciseAmountModel.OptionExerciseAmountModelBuilder toBuilder();
	
	static OptionExerciseAmountModel.OptionExerciseAmountModelBuilder builder() {
		return new OptionExerciseAmountModel.OptionExerciseAmountModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OptionExerciseAmountModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends OptionExerciseAmountModel> getType() {
		return OptionExerciseAmountModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("exerciseAction"), ExerciseActionEnum.class, getExerciseAction(), this);
		processor.processBasic(path.newSubPath("expiry"), Boolean.class, getExpiry(), this);
		processor.processBasic(path.newSubPath("fullExercise"), Boolean.class, getFullExercise(), this);
		processRosetta(path.newSubPath("optionExerciseAmountModelSequence0"), processor, OptionExerciseAmountModelSequence0.class, getOptionExerciseAmountModelSequence0());
		processRosetta(path.newSubPath("optionExerciseAmountModelSequence1"), processor, OptionExerciseAmountModelSequence1.class, getOptionExerciseAmountModelSequence1());
		processRosetta(path.newSubPath("optionExerciseAmountModelSequence2"), processor, OptionExerciseAmountModelSequence2.class, getOptionExerciseAmountModelSequence2());
		processRosetta(path.newSubPath("specifiedExercise"), processor, OptionExerciseAmounts.class, getSpecifiedExercise());
	}
	

	/*********************** Builder Interface  ***********************/
	interface OptionExerciseAmountModelBuilder extends OptionExerciseAmountModel, RosettaModelObjectBuilder {
		OptionExerciseAmountModelSequence0.OptionExerciseAmountModelSequence0Builder getOrCreateOptionExerciseAmountModelSequence0();
		OptionExerciseAmountModelSequence0.OptionExerciseAmountModelSequence0Builder getOptionExerciseAmountModelSequence0();
		OptionExerciseAmountModelSequence1.OptionExerciseAmountModelSequence1Builder getOrCreateOptionExerciseAmountModelSequence1();
		OptionExerciseAmountModelSequence1.OptionExerciseAmountModelSequence1Builder getOptionExerciseAmountModelSequence1();
		OptionExerciseAmountModelSequence2.OptionExerciseAmountModelSequence2Builder getOrCreateOptionExerciseAmountModelSequence2();
		OptionExerciseAmountModelSequence2.OptionExerciseAmountModelSequence2Builder getOptionExerciseAmountModelSequence2();
		OptionExerciseAmounts.OptionExerciseAmountsBuilder getOrCreateSpecifiedExercise(int _index);
		List<? extends OptionExerciseAmounts.OptionExerciseAmountsBuilder> getSpecifiedExercise();
		OptionExerciseAmountModel.OptionExerciseAmountModelBuilder setExerciseAction(ExerciseActionEnum exerciseAction);
		OptionExerciseAmountModel.OptionExerciseAmountModelBuilder setExpiry(Boolean expiry);
		OptionExerciseAmountModel.OptionExerciseAmountModelBuilder setFullExercise(Boolean fullExercise);
		OptionExerciseAmountModel.OptionExerciseAmountModelBuilder setOptionExerciseAmountModelSequence0(OptionExerciseAmountModelSequence0 optionExerciseAmountModelSequence0);
		OptionExerciseAmountModel.OptionExerciseAmountModelBuilder setOptionExerciseAmountModelSequence1(OptionExerciseAmountModelSequence1 optionExerciseAmountModelSequence1);
		OptionExerciseAmountModel.OptionExerciseAmountModelBuilder setOptionExerciseAmountModelSequence2(OptionExerciseAmountModelSequence2 optionExerciseAmountModelSequence2);
		OptionExerciseAmountModel.OptionExerciseAmountModelBuilder addSpecifiedExercise(OptionExerciseAmounts specifiedExercise0);
		OptionExerciseAmountModel.OptionExerciseAmountModelBuilder addSpecifiedExercise(OptionExerciseAmounts specifiedExercise1, int _idx);
		OptionExerciseAmountModel.OptionExerciseAmountModelBuilder addSpecifiedExercise(List<? extends OptionExerciseAmounts> specifiedExercise2);
		OptionExerciseAmountModel.OptionExerciseAmountModelBuilder setSpecifiedExercise(List<? extends OptionExerciseAmounts> specifiedExercise3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("exerciseAction"), ExerciseActionEnum.class, getExerciseAction(), this);
			processor.processBasic(path.newSubPath("expiry"), Boolean.class, getExpiry(), this);
			processor.processBasic(path.newSubPath("fullExercise"), Boolean.class, getFullExercise(), this);
			processRosetta(path.newSubPath("optionExerciseAmountModelSequence0"), processor, OptionExerciseAmountModelSequence0.OptionExerciseAmountModelSequence0Builder.class, getOptionExerciseAmountModelSequence0());
			processRosetta(path.newSubPath("optionExerciseAmountModelSequence1"), processor, OptionExerciseAmountModelSequence1.OptionExerciseAmountModelSequence1Builder.class, getOptionExerciseAmountModelSequence1());
			processRosetta(path.newSubPath("optionExerciseAmountModelSequence2"), processor, OptionExerciseAmountModelSequence2.OptionExerciseAmountModelSequence2Builder.class, getOptionExerciseAmountModelSequence2());
			processRosetta(path.newSubPath("specifiedExercise"), processor, OptionExerciseAmounts.OptionExerciseAmountsBuilder.class, getSpecifiedExercise());
		}
		

		OptionExerciseAmountModel.OptionExerciseAmountModelBuilder prune();
	}

	/*********************** Immutable Implementation of OptionExerciseAmountModel  ***********************/
	class OptionExerciseAmountModelImpl implements OptionExerciseAmountModel {
		private final ExerciseActionEnum exerciseAction;
		private final Boolean expiry;
		private final Boolean fullExercise;
		private final OptionExerciseAmountModelSequence0 optionExerciseAmountModelSequence0;
		private final OptionExerciseAmountModelSequence1 optionExerciseAmountModelSequence1;
		private final OptionExerciseAmountModelSequence2 optionExerciseAmountModelSequence2;
		private final List<? extends OptionExerciseAmounts> specifiedExercise;
		
		protected OptionExerciseAmountModelImpl(OptionExerciseAmountModel.OptionExerciseAmountModelBuilder builder) {
			this.exerciseAction = builder.getExerciseAction();
			this.expiry = builder.getExpiry();
			this.fullExercise = builder.getFullExercise();
			this.optionExerciseAmountModelSequence0 = ofNullable(builder.getOptionExerciseAmountModelSequence0()).map(f->f.build()).orElse(null);
			this.optionExerciseAmountModelSequence1 = ofNullable(builder.getOptionExerciseAmountModelSequence1()).map(f->f.build()).orElse(null);
			this.optionExerciseAmountModelSequence2 = ofNullable(builder.getOptionExerciseAmountModelSequence2()).map(f->f.build()).orElse(null);
			this.specifiedExercise = ofNullable(builder.getSpecifiedExercise()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("exerciseAction")
		public ExerciseActionEnum getExerciseAction() {
			return exerciseAction;
		}
		
		@Override
		@RosettaAttribute("expiry")
		public Boolean getExpiry() {
			return expiry;
		}
		
		@Override
		@RosettaAttribute("fullExercise")
		public Boolean getFullExercise() {
			return fullExercise;
		}
		
		@Override
		@RosettaAttribute("optionExerciseAmountModelSequence0")
		public OptionExerciseAmountModelSequence0 getOptionExerciseAmountModelSequence0() {
			return optionExerciseAmountModelSequence0;
		}
		
		@Override
		@RosettaAttribute("optionExerciseAmountModelSequence1")
		public OptionExerciseAmountModelSequence1 getOptionExerciseAmountModelSequence1() {
			return optionExerciseAmountModelSequence1;
		}
		
		@Override
		@RosettaAttribute("optionExerciseAmountModelSequence2")
		public OptionExerciseAmountModelSequence2 getOptionExerciseAmountModelSequence2() {
			return optionExerciseAmountModelSequence2;
		}
		
		@Override
		@RosettaAttribute("specifiedExercise")
		public List<? extends OptionExerciseAmounts> getSpecifiedExercise() {
			return specifiedExercise;
		}
		
		@Override
		public OptionExerciseAmountModel build() {
			return this;
		}
		
		@Override
		public OptionExerciseAmountModel.OptionExerciseAmountModelBuilder toBuilder() {
			OptionExerciseAmountModel.OptionExerciseAmountModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OptionExerciseAmountModel.OptionExerciseAmountModelBuilder builder) {
			ofNullable(getExerciseAction()).ifPresent(builder::setExerciseAction);
			ofNullable(getExpiry()).ifPresent(builder::setExpiry);
			ofNullable(getFullExercise()).ifPresent(builder::setFullExercise);
			ofNullable(getOptionExerciseAmountModelSequence0()).ifPresent(builder::setOptionExerciseAmountModelSequence0);
			ofNullable(getOptionExerciseAmountModelSequence1()).ifPresent(builder::setOptionExerciseAmountModelSequence1);
			ofNullable(getOptionExerciseAmountModelSequence2()).ifPresent(builder::setOptionExerciseAmountModelSequence2);
			ofNullable(getSpecifiedExercise()).ifPresent(builder::setSpecifiedExercise);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OptionExerciseAmountModel _that = getType().cast(o);
		
			if (!Objects.equals(exerciseAction, _that.getExerciseAction())) return false;
			if (!Objects.equals(expiry, _that.getExpiry())) return false;
			if (!Objects.equals(fullExercise, _that.getFullExercise())) return false;
			if (!Objects.equals(optionExerciseAmountModelSequence0, _that.getOptionExerciseAmountModelSequence0())) return false;
			if (!Objects.equals(optionExerciseAmountModelSequence1, _that.getOptionExerciseAmountModelSequence1())) return false;
			if (!Objects.equals(optionExerciseAmountModelSequence2, _that.getOptionExerciseAmountModelSequence2())) return false;
			if (!ListEquals.listEquals(specifiedExercise, _that.getSpecifiedExercise())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (exerciseAction != null ? exerciseAction.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (expiry != null ? expiry.hashCode() : 0);
			_result = 31 * _result + (fullExercise != null ? fullExercise.hashCode() : 0);
			_result = 31 * _result + (optionExerciseAmountModelSequence0 != null ? optionExerciseAmountModelSequence0.hashCode() : 0);
			_result = 31 * _result + (optionExerciseAmountModelSequence1 != null ? optionExerciseAmountModelSequence1.hashCode() : 0);
			_result = 31 * _result + (optionExerciseAmountModelSequence2 != null ? optionExerciseAmountModelSequence2.hashCode() : 0);
			_result = 31 * _result + (specifiedExercise != null ? specifiedExercise.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionExerciseAmountModel {" +
				"exerciseAction=" + this.exerciseAction + ", " +
				"expiry=" + this.expiry + ", " +
				"fullExercise=" + this.fullExercise + ", " +
				"optionExerciseAmountModelSequence0=" + this.optionExerciseAmountModelSequence0 + ", " +
				"optionExerciseAmountModelSequence1=" + this.optionExerciseAmountModelSequence1 + ", " +
				"optionExerciseAmountModelSequence2=" + this.optionExerciseAmountModelSequence2 + ", " +
				"specifiedExercise=" + this.specifiedExercise +
			'}';
		}
	}

	/*********************** Builder Implementation of OptionExerciseAmountModel  ***********************/
	class OptionExerciseAmountModelBuilderImpl implements OptionExerciseAmountModel.OptionExerciseAmountModelBuilder {
	
		protected ExerciseActionEnum exerciseAction;
		protected Boolean expiry;
		protected Boolean fullExercise;
		protected OptionExerciseAmountModelSequence0.OptionExerciseAmountModelSequence0Builder optionExerciseAmountModelSequence0;
		protected OptionExerciseAmountModelSequence1.OptionExerciseAmountModelSequence1Builder optionExerciseAmountModelSequence1;
		protected OptionExerciseAmountModelSequence2.OptionExerciseAmountModelSequence2Builder optionExerciseAmountModelSequence2;
		protected List<OptionExerciseAmounts.OptionExerciseAmountsBuilder> specifiedExercise = new ArrayList<>();
	
		public OptionExerciseAmountModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("exerciseAction")
		public ExerciseActionEnum getExerciseAction() {
			return exerciseAction;
		}
		
		@Override
		@RosettaAttribute("expiry")
		public Boolean getExpiry() {
			return expiry;
		}
		
		@Override
		@RosettaAttribute("fullExercise")
		public Boolean getFullExercise() {
			return fullExercise;
		}
		
		@Override
		@RosettaAttribute("optionExerciseAmountModelSequence0")
		public OptionExerciseAmountModelSequence0.OptionExerciseAmountModelSequence0Builder getOptionExerciseAmountModelSequence0() {
			return optionExerciseAmountModelSequence0;
		}
		
		@Override
		public OptionExerciseAmountModelSequence0.OptionExerciseAmountModelSequence0Builder getOrCreateOptionExerciseAmountModelSequence0() {
			OptionExerciseAmountModelSequence0.OptionExerciseAmountModelSequence0Builder result;
			if (optionExerciseAmountModelSequence0!=null) {
				result = optionExerciseAmountModelSequence0;
			}
			else {
				result = optionExerciseAmountModelSequence0 = OptionExerciseAmountModelSequence0.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("optionExerciseAmountModelSequence1")
		public OptionExerciseAmountModelSequence1.OptionExerciseAmountModelSequence1Builder getOptionExerciseAmountModelSequence1() {
			return optionExerciseAmountModelSequence1;
		}
		
		@Override
		public OptionExerciseAmountModelSequence1.OptionExerciseAmountModelSequence1Builder getOrCreateOptionExerciseAmountModelSequence1() {
			OptionExerciseAmountModelSequence1.OptionExerciseAmountModelSequence1Builder result;
			if (optionExerciseAmountModelSequence1!=null) {
				result = optionExerciseAmountModelSequence1;
			}
			else {
				result = optionExerciseAmountModelSequence1 = OptionExerciseAmountModelSequence1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("optionExerciseAmountModelSequence2")
		public OptionExerciseAmountModelSequence2.OptionExerciseAmountModelSequence2Builder getOptionExerciseAmountModelSequence2() {
			return optionExerciseAmountModelSequence2;
		}
		
		@Override
		public OptionExerciseAmountModelSequence2.OptionExerciseAmountModelSequence2Builder getOrCreateOptionExerciseAmountModelSequence2() {
			OptionExerciseAmountModelSequence2.OptionExerciseAmountModelSequence2Builder result;
			if (optionExerciseAmountModelSequence2!=null) {
				result = optionExerciseAmountModelSequence2;
			}
			else {
				result = optionExerciseAmountModelSequence2 = OptionExerciseAmountModelSequence2.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("specifiedExercise")
		public List<? extends OptionExerciseAmounts.OptionExerciseAmountsBuilder> getSpecifiedExercise() {
			return specifiedExercise;
		}
		
		@Override
		public OptionExerciseAmounts.OptionExerciseAmountsBuilder getOrCreateSpecifiedExercise(int _index) {
		
			if (specifiedExercise==null) {
				this.specifiedExercise = new ArrayList<>();
			}
			OptionExerciseAmounts.OptionExerciseAmountsBuilder result;
			return getIndex(specifiedExercise, _index, () -> {
						OptionExerciseAmounts.OptionExerciseAmountsBuilder newSpecifiedExercise = OptionExerciseAmounts.builder();
						return newSpecifiedExercise;
					});
		}
		
		@Override
		@RosettaAttribute("exerciseAction")
		public OptionExerciseAmountModel.OptionExerciseAmountModelBuilder setExerciseAction(ExerciseActionEnum exerciseAction) {
			this.exerciseAction = exerciseAction==null?null:exerciseAction;
			return this;
		}
		@Override
		@RosettaAttribute("expiry")
		public OptionExerciseAmountModel.OptionExerciseAmountModelBuilder setExpiry(Boolean expiry) {
			this.expiry = expiry==null?null:expiry;
			return this;
		}
		@Override
		@RosettaAttribute("fullExercise")
		public OptionExerciseAmountModel.OptionExerciseAmountModelBuilder setFullExercise(Boolean fullExercise) {
			this.fullExercise = fullExercise==null?null:fullExercise;
			return this;
		}
		@Override
		@RosettaAttribute("optionExerciseAmountModelSequence0")
		public OptionExerciseAmountModel.OptionExerciseAmountModelBuilder setOptionExerciseAmountModelSequence0(OptionExerciseAmountModelSequence0 optionExerciseAmountModelSequence0) {
			this.optionExerciseAmountModelSequence0 = optionExerciseAmountModelSequence0==null?null:optionExerciseAmountModelSequence0.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("optionExerciseAmountModelSequence1")
		public OptionExerciseAmountModel.OptionExerciseAmountModelBuilder setOptionExerciseAmountModelSequence1(OptionExerciseAmountModelSequence1 optionExerciseAmountModelSequence1) {
			this.optionExerciseAmountModelSequence1 = optionExerciseAmountModelSequence1==null?null:optionExerciseAmountModelSequence1.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("optionExerciseAmountModelSequence2")
		public OptionExerciseAmountModel.OptionExerciseAmountModelBuilder setOptionExerciseAmountModelSequence2(OptionExerciseAmountModelSequence2 optionExerciseAmountModelSequence2) {
			this.optionExerciseAmountModelSequence2 = optionExerciseAmountModelSequence2==null?null:optionExerciseAmountModelSequence2.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("specifiedExercise")
		public OptionExerciseAmountModel.OptionExerciseAmountModelBuilder addSpecifiedExercise(OptionExerciseAmounts specifiedExercise) {
			if (specifiedExercise!=null) this.specifiedExercise.add(specifiedExercise.toBuilder());
			return this;
		}
		
		@Override
		public OptionExerciseAmountModel.OptionExerciseAmountModelBuilder addSpecifiedExercise(OptionExerciseAmounts specifiedExercise, int _idx) {
			getIndex(this.specifiedExercise, _idx, () -> specifiedExercise.toBuilder());
			return this;
		}
		@Override 
		public OptionExerciseAmountModel.OptionExerciseAmountModelBuilder addSpecifiedExercise(List<? extends OptionExerciseAmounts> specifiedExercises) {
			if (specifiedExercises != null) {
				for (OptionExerciseAmounts toAdd : specifiedExercises) {
					this.specifiedExercise.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public OptionExerciseAmountModel.OptionExerciseAmountModelBuilder setSpecifiedExercise(List<? extends OptionExerciseAmounts> specifiedExercises) {
			if (specifiedExercises == null)  {
				this.specifiedExercise = new ArrayList<>();
			}
			else {
				this.specifiedExercise = specifiedExercises.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public OptionExerciseAmountModel build() {
			return new OptionExerciseAmountModel.OptionExerciseAmountModelImpl(this);
		}
		
		@Override
		public OptionExerciseAmountModel.OptionExerciseAmountModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionExerciseAmountModel.OptionExerciseAmountModelBuilder prune() {
			if (optionExerciseAmountModelSequence0!=null && !optionExerciseAmountModelSequence0.prune().hasData()) optionExerciseAmountModelSequence0 = null;
			if (optionExerciseAmountModelSequence1!=null && !optionExerciseAmountModelSequence1.prune().hasData()) optionExerciseAmountModelSequence1 = null;
			if (optionExerciseAmountModelSequence2!=null && !optionExerciseAmountModelSequence2.prune().hasData()) optionExerciseAmountModelSequence2 = null;
			specifiedExercise = specifiedExercise.stream().filter(b->b!=null).<OptionExerciseAmounts.OptionExerciseAmountsBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getExerciseAction()!=null) return true;
			if (getExpiry()!=null) return true;
			if (getFullExercise()!=null) return true;
			if (getOptionExerciseAmountModelSequence0()!=null && getOptionExerciseAmountModelSequence0().hasData()) return true;
			if (getOptionExerciseAmountModelSequence1()!=null && getOptionExerciseAmountModelSequence1().hasData()) return true;
			if (getOptionExerciseAmountModelSequence2()!=null && getOptionExerciseAmountModelSequence2().hasData()) return true;
			if (getSpecifiedExercise()!=null && getSpecifiedExercise().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionExerciseAmountModel.OptionExerciseAmountModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			OptionExerciseAmountModel.OptionExerciseAmountModelBuilder o = (OptionExerciseAmountModel.OptionExerciseAmountModelBuilder) other;
			
			merger.mergeRosetta(getOptionExerciseAmountModelSequence0(), o.getOptionExerciseAmountModelSequence0(), this::setOptionExerciseAmountModelSequence0);
			merger.mergeRosetta(getOptionExerciseAmountModelSequence1(), o.getOptionExerciseAmountModelSequence1(), this::setOptionExerciseAmountModelSequence1);
			merger.mergeRosetta(getOptionExerciseAmountModelSequence2(), o.getOptionExerciseAmountModelSequence2(), this::setOptionExerciseAmountModelSequence2);
			merger.mergeRosetta(getSpecifiedExercise(), o.getSpecifiedExercise(), this::getOrCreateSpecifiedExercise);
			
			merger.mergeBasic(getExerciseAction(), o.getExerciseAction(), this::setExerciseAction);
			merger.mergeBasic(getExpiry(), o.getExpiry(), this::setExpiry);
			merger.mergeBasic(getFullExercise(), o.getFullExercise(), this::setFullExercise);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OptionExerciseAmountModel _that = getType().cast(o);
		
			if (!Objects.equals(exerciseAction, _that.getExerciseAction())) return false;
			if (!Objects.equals(expiry, _that.getExpiry())) return false;
			if (!Objects.equals(fullExercise, _that.getFullExercise())) return false;
			if (!Objects.equals(optionExerciseAmountModelSequence0, _that.getOptionExerciseAmountModelSequence0())) return false;
			if (!Objects.equals(optionExerciseAmountModelSequence1, _that.getOptionExerciseAmountModelSequence1())) return false;
			if (!Objects.equals(optionExerciseAmountModelSequence2, _that.getOptionExerciseAmountModelSequence2())) return false;
			if (!ListEquals.listEquals(specifiedExercise, _that.getSpecifiedExercise())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (exerciseAction != null ? exerciseAction.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (expiry != null ? expiry.hashCode() : 0);
			_result = 31 * _result + (fullExercise != null ? fullExercise.hashCode() : 0);
			_result = 31 * _result + (optionExerciseAmountModelSequence0 != null ? optionExerciseAmountModelSequence0.hashCode() : 0);
			_result = 31 * _result + (optionExerciseAmountModelSequence1 != null ? optionExerciseAmountModelSequence1.hashCode() : 0);
			_result = 31 * _result + (optionExerciseAmountModelSequence2 != null ? optionExerciseAmountModelSequence2.hashCode() : 0);
			_result = 31 * _result + (specifiedExercise != null ? specifiedExercise.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionExerciseAmountModelBuilder {" +
				"exerciseAction=" + this.exerciseAction + ", " +
				"expiry=" + this.expiry + ", " +
				"fullExercise=" + this.fullExercise + ", " +
				"optionExerciseAmountModelSequence0=" + this.optionExerciseAmountModelSequence0 + ", " +
				"optionExerciseAmountModelSequence1=" + this.optionExerciseAmountModelSequence1 + ", " +
				"optionExerciseAmountModelSequence2=" + this.optionExerciseAmountModelSequence2 + ", " +
				"specifiedExercise=" + this.specifiedExercise +
			'}';
		}
	}
}
