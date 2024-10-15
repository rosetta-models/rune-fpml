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
import fpml.confirmation.AdjustableDate2;
import fpml.confirmation.GenericExerciseStyle;
import fpml.confirmation.GenericOptionAttributesModel;
import fpml.confirmation.GenericOptionAttributesModel.GenericOptionAttributesModelBuilder;
import fpml.confirmation.GenericOptionAttributesModel.GenericOptionAttributesModelBuilderImpl;
import fpml.confirmation.GenericOptionAttributesModel.GenericOptionAttributesModelImpl;
import fpml.confirmation.GenericOptionStrike;
import fpml.confirmation.GenericProductFeature;
import fpml.confirmation.OptionType;
import fpml.confirmation.meta.GenericOptionAttributesModelMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="GenericOptionAttributesModel", builder=GenericOptionAttributesModel.GenericOptionAttributesModelBuilderImpl.class, version="${project.version}")
public interface GenericOptionAttributesModel extends RosettaModelObject {

	GenericOptionAttributesModelMeta metaData = new GenericOptionAttributesModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * For options, what type of option it is (e.g. butterfly).
	 */
	OptionType getOptionType();
	/**
	 * For options, the earliest exercise date of the option. (For CFTC Part 43, this element corresponds to the option lock-out period defined in the option field table).
	 */
	AdjustableDate2 getCommencementDate();
	/**
	 * For options, whether the option is a put or call option.
	 */
	GenericExerciseStyle getExerciseStyle();
	/**
	 * The option strike or strikes.
	 */
	List<? extends GenericOptionStrike> getStrike();
	/**
	 * Special features that the option may have, such as Asian averaging, Barriers, Digital payout, etc.
	 */
	List<? extends GenericProductFeature> getFeature();

	/*********************** Build Methods  ***********************/
	GenericOptionAttributesModel build();
	
	GenericOptionAttributesModel.GenericOptionAttributesModelBuilder toBuilder();
	
	static GenericOptionAttributesModel.GenericOptionAttributesModelBuilder builder() {
		return new GenericOptionAttributesModel.GenericOptionAttributesModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends GenericOptionAttributesModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends GenericOptionAttributesModel> getType() {
		return GenericOptionAttributesModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("optionType"), processor, OptionType.class, getOptionType());
		processRosetta(path.newSubPath("commencementDate"), processor, AdjustableDate2.class, getCommencementDate());
		processRosetta(path.newSubPath("exerciseStyle"), processor, GenericExerciseStyle.class, getExerciseStyle());
		processRosetta(path.newSubPath("strike"), processor, GenericOptionStrike.class, getStrike());
		processRosetta(path.newSubPath("feature"), processor, GenericProductFeature.class, getFeature());
	}
	

	/*********************** Builder Interface  ***********************/
	interface GenericOptionAttributesModelBuilder extends GenericOptionAttributesModel, RosettaModelObjectBuilder {
		OptionType.OptionTypeBuilder getOrCreateOptionType();
		OptionType.OptionTypeBuilder getOptionType();
		AdjustableDate2.AdjustableDate2Builder getOrCreateCommencementDate();
		AdjustableDate2.AdjustableDate2Builder getCommencementDate();
		GenericExerciseStyle.GenericExerciseStyleBuilder getOrCreateExerciseStyle();
		GenericExerciseStyle.GenericExerciseStyleBuilder getExerciseStyle();
		GenericOptionStrike.GenericOptionStrikeBuilder getOrCreateStrike(int _index);
		List<? extends GenericOptionStrike.GenericOptionStrikeBuilder> getStrike();
		GenericProductFeature.GenericProductFeatureBuilder getOrCreateFeature(int _index);
		List<? extends GenericProductFeature.GenericProductFeatureBuilder> getFeature();
		GenericOptionAttributesModel.GenericOptionAttributesModelBuilder setOptionType(OptionType optionType);
		GenericOptionAttributesModel.GenericOptionAttributesModelBuilder setCommencementDate(AdjustableDate2 commencementDate);
		GenericOptionAttributesModel.GenericOptionAttributesModelBuilder setExerciseStyle(GenericExerciseStyle exerciseStyle);
		GenericOptionAttributesModel.GenericOptionAttributesModelBuilder addStrike(GenericOptionStrike strike0);
		GenericOptionAttributesModel.GenericOptionAttributesModelBuilder addStrike(GenericOptionStrike strike1, int _idx);
		GenericOptionAttributesModel.GenericOptionAttributesModelBuilder addStrike(List<? extends GenericOptionStrike> strike2);
		GenericOptionAttributesModel.GenericOptionAttributesModelBuilder setStrike(List<? extends GenericOptionStrike> strike3);
		GenericOptionAttributesModel.GenericOptionAttributesModelBuilder addFeature(GenericProductFeature feature0);
		GenericOptionAttributesModel.GenericOptionAttributesModelBuilder addFeature(GenericProductFeature feature1, int _idx);
		GenericOptionAttributesModel.GenericOptionAttributesModelBuilder addFeature(List<? extends GenericProductFeature> feature2);
		GenericOptionAttributesModel.GenericOptionAttributesModelBuilder setFeature(List<? extends GenericProductFeature> feature3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("optionType"), processor, OptionType.OptionTypeBuilder.class, getOptionType());
			processRosetta(path.newSubPath("commencementDate"), processor, AdjustableDate2.AdjustableDate2Builder.class, getCommencementDate());
			processRosetta(path.newSubPath("exerciseStyle"), processor, GenericExerciseStyle.GenericExerciseStyleBuilder.class, getExerciseStyle());
			processRosetta(path.newSubPath("strike"), processor, GenericOptionStrike.GenericOptionStrikeBuilder.class, getStrike());
			processRosetta(path.newSubPath("feature"), processor, GenericProductFeature.GenericProductFeatureBuilder.class, getFeature());
		}
		

		GenericOptionAttributesModel.GenericOptionAttributesModelBuilder prune();
	}

	/*********************** Immutable Implementation of GenericOptionAttributesModel  ***********************/
	class GenericOptionAttributesModelImpl implements GenericOptionAttributesModel {
		private final OptionType optionType;
		private final AdjustableDate2 commencementDate;
		private final GenericExerciseStyle exerciseStyle;
		private final List<? extends GenericOptionStrike> strike;
		private final List<? extends GenericProductFeature> feature;
		
		protected GenericOptionAttributesModelImpl(GenericOptionAttributesModel.GenericOptionAttributesModelBuilder builder) {
			this.optionType = ofNullable(builder.getOptionType()).map(f->f.build()).orElse(null);
			this.commencementDate = ofNullable(builder.getCommencementDate()).map(f->f.build()).orElse(null);
			this.exerciseStyle = ofNullable(builder.getExerciseStyle()).map(f->f.build()).orElse(null);
			this.strike = ofNullable(builder.getStrike()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.feature = ofNullable(builder.getFeature()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("optionType")
		public OptionType getOptionType() {
			return optionType;
		}
		
		@Override
		@RosettaAttribute("commencementDate")
		public AdjustableDate2 getCommencementDate() {
			return commencementDate;
		}
		
		@Override
		@RosettaAttribute("exerciseStyle")
		public GenericExerciseStyle getExerciseStyle() {
			return exerciseStyle;
		}
		
		@Override
		@RosettaAttribute("strike")
		public List<? extends GenericOptionStrike> getStrike() {
			return strike;
		}
		
		@Override
		@RosettaAttribute("feature")
		public List<? extends GenericProductFeature> getFeature() {
			return feature;
		}
		
		@Override
		public GenericOptionAttributesModel build() {
			return this;
		}
		
		@Override
		public GenericOptionAttributesModel.GenericOptionAttributesModelBuilder toBuilder() {
			GenericOptionAttributesModel.GenericOptionAttributesModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(GenericOptionAttributesModel.GenericOptionAttributesModelBuilder builder) {
			ofNullable(getOptionType()).ifPresent(builder::setOptionType);
			ofNullable(getCommencementDate()).ifPresent(builder::setCommencementDate);
			ofNullable(getExerciseStyle()).ifPresent(builder::setExerciseStyle);
			ofNullable(getStrike()).ifPresent(builder::setStrike);
			ofNullable(getFeature()).ifPresent(builder::setFeature);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			GenericOptionAttributesModel _that = getType().cast(o);
		
			if (!Objects.equals(optionType, _that.getOptionType())) return false;
			if (!Objects.equals(commencementDate, _that.getCommencementDate())) return false;
			if (!Objects.equals(exerciseStyle, _that.getExerciseStyle())) return false;
			if (!ListEquals.listEquals(strike, _that.getStrike())) return false;
			if (!ListEquals.listEquals(feature, _that.getFeature())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (optionType != null ? optionType.hashCode() : 0);
			_result = 31 * _result + (commencementDate != null ? commencementDate.hashCode() : 0);
			_result = 31 * _result + (exerciseStyle != null ? exerciseStyle.hashCode() : 0);
			_result = 31 * _result + (strike != null ? strike.hashCode() : 0);
			_result = 31 * _result + (feature != null ? feature.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GenericOptionAttributesModel {" +
				"optionType=" + this.optionType + ", " +
				"commencementDate=" + this.commencementDate + ", " +
				"exerciseStyle=" + this.exerciseStyle + ", " +
				"strike=" + this.strike + ", " +
				"feature=" + this.feature +
			'}';
		}
	}

	/*********************** Builder Implementation of GenericOptionAttributesModel  ***********************/
	class GenericOptionAttributesModelBuilderImpl implements GenericOptionAttributesModel.GenericOptionAttributesModelBuilder {
	
		protected OptionType.OptionTypeBuilder optionType;
		protected AdjustableDate2.AdjustableDate2Builder commencementDate;
		protected GenericExerciseStyle.GenericExerciseStyleBuilder exerciseStyle;
		protected List<GenericOptionStrike.GenericOptionStrikeBuilder> strike = new ArrayList<>();
		protected List<GenericProductFeature.GenericProductFeatureBuilder> feature = new ArrayList<>();
	
		public GenericOptionAttributesModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("optionType")
		public OptionType.OptionTypeBuilder getOptionType() {
			return optionType;
		}
		
		@Override
		public OptionType.OptionTypeBuilder getOrCreateOptionType() {
			OptionType.OptionTypeBuilder result;
			if (optionType!=null) {
				result = optionType;
			}
			else {
				result = optionType = OptionType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("commencementDate")
		public AdjustableDate2.AdjustableDate2Builder getCommencementDate() {
			return commencementDate;
		}
		
		@Override
		public AdjustableDate2.AdjustableDate2Builder getOrCreateCommencementDate() {
			AdjustableDate2.AdjustableDate2Builder result;
			if (commencementDate!=null) {
				result = commencementDate;
			}
			else {
				result = commencementDate = AdjustableDate2.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("exerciseStyle")
		public GenericExerciseStyle.GenericExerciseStyleBuilder getExerciseStyle() {
			return exerciseStyle;
		}
		
		@Override
		public GenericExerciseStyle.GenericExerciseStyleBuilder getOrCreateExerciseStyle() {
			GenericExerciseStyle.GenericExerciseStyleBuilder result;
			if (exerciseStyle!=null) {
				result = exerciseStyle;
			}
			else {
				result = exerciseStyle = GenericExerciseStyle.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("strike")
		public List<? extends GenericOptionStrike.GenericOptionStrikeBuilder> getStrike() {
			return strike;
		}
		
		public GenericOptionStrike.GenericOptionStrikeBuilder getOrCreateStrike(int _index) {
		
			if (strike==null) {
				this.strike = new ArrayList<>();
			}
			GenericOptionStrike.GenericOptionStrikeBuilder result;
			return getIndex(strike, _index, () -> {
						GenericOptionStrike.GenericOptionStrikeBuilder newStrike = GenericOptionStrike.builder();
						return newStrike;
					});
		}
		
		@Override
		@RosettaAttribute("feature")
		public List<? extends GenericProductFeature.GenericProductFeatureBuilder> getFeature() {
			return feature;
		}
		
		public GenericProductFeature.GenericProductFeatureBuilder getOrCreateFeature(int _index) {
		
			if (feature==null) {
				this.feature = new ArrayList<>();
			}
			GenericProductFeature.GenericProductFeatureBuilder result;
			return getIndex(feature, _index, () -> {
						GenericProductFeature.GenericProductFeatureBuilder newFeature = GenericProductFeature.builder();
						return newFeature;
					});
		}
		
		@Override
		@RosettaAttribute("optionType")
		public GenericOptionAttributesModel.GenericOptionAttributesModelBuilder setOptionType(OptionType optionType) {
			this.optionType = optionType==null?null:optionType.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("commencementDate")
		public GenericOptionAttributesModel.GenericOptionAttributesModelBuilder setCommencementDate(AdjustableDate2 commencementDate) {
			this.commencementDate = commencementDate==null?null:commencementDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exerciseStyle")
		public GenericOptionAttributesModel.GenericOptionAttributesModelBuilder setExerciseStyle(GenericExerciseStyle exerciseStyle) {
			this.exerciseStyle = exerciseStyle==null?null:exerciseStyle.toBuilder();
			return this;
		}
		@Override
		public GenericOptionAttributesModel.GenericOptionAttributesModelBuilder addStrike(GenericOptionStrike strike) {
			if (strike!=null) this.strike.add(strike.toBuilder());
			return this;
		}
		
		@Override
		public GenericOptionAttributesModel.GenericOptionAttributesModelBuilder addStrike(GenericOptionStrike strike, int _idx) {
			getIndex(this.strike, _idx, () -> strike.toBuilder());
			return this;
		}
		@Override 
		public GenericOptionAttributesModel.GenericOptionAttributesModelBuilder addStrike(List<? extends GenericOptionStrike> strikes) {
			if (strikes != null) {
				for (GenericOptionStrike toAdd : strikes) {
					this.strike.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("strike")
		public GenericOptionAttributesModel.GenericOptionAttributesModelBuilder setStrike(List<? extends GenericOptionStrike> strikes) {
			if (strikes == null)  {
				this.strike = new ArrayList<>();
			}
			else {
				this.strike = strikes.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public GenericOptionAttributesModel.GenericOptionAttributesModelBuilder addFeature(GenericProductFeature feature) {
			if (feature!=null) this.feature.add(feature.toBuilder());
			return this;
		}
		
		@Override
		public GenericOptionAttributesModel.GenericOptionAttributesModelBuilder addFeature(GenericProductFeature feature, int _idx) {
			getIndex(this.feature, _idx, () -> feature.toBuilder());
			return this;
		}
		@Override 
		public GenericOptionAttributesModel.GenericOptionAttributesModelBuilder addFeature(List<? extends GenericProductFeature> features) {
			if (features != null) {
				for (GenericProductFeature toAdd : features) {
					this.feature.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("feature")
		public GenericOptionAttributesModel.GenericOptionAttributesModelBuilder setFeature(List<? extends GenericProductFeature> features) {
			if (features == null)  {
				this.feature = new ArrayList<>();
			}
			else {
				this.feature = features.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public GenericOptionAttributesModel build() {
			return new GenericOptionAttributesModel.GenericOptionAttributesModelImpl(this);
		}
		
		@Override
		public GenericOptionAttributesModel.GenericOptionAttributesModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GenericOptionAttributesModel.GenericOptionAttributesModelBuilder prune() {
			if (optionType!=null && !optionType.prune().hasData()) optionType = null;
			if (commencementDate!=null && !commencementDate.prune().hasData()) commencementDate = null;
			if (exerciseStyle!=null && !exerciseStyle.prune().hasData()) exerciseStyle = null;
			strike = strike.stream().filter(b->b!=null).<GenericOptionStrike.GenericOptionStrikeBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			feature = feature.stream().filter(b->b!=null).<GenericProductFeature.GenericProductFeatureBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getOptionType()!=null && getOptionType().hasData()) return true;
			if (getCommencementDate()!=null && getCommencementDate().hasData()) return true;
			if (getExerciseStyle()!=null && getExerciseStyle().hasData()) return true;
			if (getStrike()!=null && getStrike().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getFeature()!=null && getFeature().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GenericOptionAttributesModel.GenericOptionAttributesModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			GenericOptionAttributesModel.GenericOptionAttributesModelBuilder o = (GenericOptionAttributesModel.GenericOptionAttributesModelBuilder) other;
			
			merger.mergeRosetta(getOptionType(), o.getOptionType(), this::setOptionType);
			merger.mergeRosetta(getCommencementDate(), o.getCommencementDate(), this::setCommencementDate);
			merger.mergeRosetta(getExerciseStyle(), o.getExerciseStyle(), this::setExerciseStyle);
			merger.mergeRosetta(getStrike(), o.getStrike(), this::getOrCreateStrike);
			merger.mergeRosetta(getFeature(), o.getFeature(), this::getOrCreateFeature);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			GenericOptionAttributesModel _that = getType().cast(o);
		
			if (!Objects.equals(optionType, _that.getOptionType())) return false;
			if (!Objects.equals(commencementDate, _that.getCommencementDate())) return false;
			if (!Objects.equals(exerciseStyle, _that.getExerciseStyle())) return false;
			if (!ListEquals.listEquals(strike, _that.getStrike())) return false;
			if (!ListEquals.listEquals(feature, _that.getFeature())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (optionType != null ? optionType.hashCode() : 0);
			_result = 31 * _result + (commencementDate != null ? commencementDate.hashCode() : 0);
			_result = 31 * _result + (exerciseStyle != null ? exerciseStyle.hashCode() : 0);
			_result = 31 * _result + (strike != null ? strike.hashCode() : 0);
			_result = 31 * _result + (feature != null ? feature.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GenericOptionAttributesModelBuilder {" +
				"optionType=" + this.optionType + ", " +
				"commencementDate=" + this.commencementDate + ", " +
				"exerciseStyle=" + this.exerciseStyle + ", " +
				"strike=" + this.strike + ", " +
				"feature=" + this.feature +
			'}';
		}
	}
}
