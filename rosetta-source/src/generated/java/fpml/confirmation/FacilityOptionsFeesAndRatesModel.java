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
import fpml.confirmation.AccruingFeeOption;
import fpml.confirmation.AccruingPikOption;
import fpml.confirmation.FacilityOptionsFeesAndRatesModel;
import fpml.confirmation.FacilityOptionsFeesAndRatesModel.FacilityOptionsFeesAndRatesModelBuilder;
import fpml.confirmation.FacilityOptionsFeesAndRatesModel.FacilityOptionsFeesAndRatesModelBuilderImpl;
import fpml.confirmation.FacilityOptionsFeesAndRatesModel.FacilityOptionsFeesAndRatesModelImpl;
import fpml.confirmation.FacilityOptionsFeesAndRatesModelChoice;
import fpml.confirmation.FacilityRatesModel;
import fpml.confirmation.meta.FacilityOptionsFeesAndRatesModelMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A model that describes additional (non-static) facility rate details. These are managed separate since they can change independently during the life of the facility.
 * @version ${project.version}
 */
@RosettaDataType(value="FacilityOptionsFeesAndRatesModel", builder=FacilityOptionsFeesAndRatesModel.FacilityOptionsFeesAndRatesModelBuilderImpl.class, version="${project.version}")
public interface FacilityOptionsFeesAndRatesModel extends RosettaModelObject {

	FacilityOptionsFeesAndRatesModelMeta metaData = new FacilityOptionsFeesAndRatesModelMeta();

	/*********************** Getter Methods  ***********************/
	List<? extends FacilityOptionsFeesAndRatesModelChoice> getFacilityOptionsFeesAndRatesModelChoice();
	/**
	 * A loan contract PIK accrual option.
	 */
	AccruingPikOption getAccruingPikOption();
	/**
	 * A description of all the different types of accruing fees which apply to the facility.
	 */
	List<? extends AccruingFeeOption> getAccruingFeeOption();
	FacilityRatesModel getFacilityRatesModel();

	/*********************** Build Methods  ***********************/
	FacilityOptionsFeesAndRatesModel build();
	
	FacilityOptionsFeesAndRatesModel.FacilityOptionsFeesAndRatesModelBuilder toBuilder();
	
	static FacilityOptionsFeesAndRatesModel.FacilityOptionsFeesAndRatesModelBuilder builder() {
		return new FacilityOptionsFeesAndRatesModel.FacilityOptionsFeesAndRatesModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FacilityOptionsFeesAndRatesModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FacilityOptionsFeesAndRatesModel> getType() {
		return FacilityOptionsFeesAndRatesModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("facilityOptionsFeesAndRatesModelChoice"), processor, FacilityOptionsFeesAndRatesModelChoice.class, getFacilityOptionsFeesAndRatesModelChoice());
		processRosetta(path.newSubPath("accruingPikOption"), processor, AccruingPikOption.class, getAccruingPikOption());
		processRosetta(path.newSubPath("accruingFeeOption"), processor, AccruingFeeOption.class, getAccruingFeeOption());
		processRosetta(path.newSubPath("facilityRatesModel"), processor, FacilityRatesModel.class, getFacilityRatesModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FacilityOptionsFeesAndRatesModelBuilder extends FacilityOptionsFeesAndRatesModel, RosettaModelObjectBuilder {
		FacilityOptionsFeesAndRatesModelChoice.FacilityOptionsFeesAndRatesModelChoiceBuilder getOrCreateFacilityOptionsFeesAndRatesModelChoice(int _index);
		List<? extends FacilityOptionsFeesAndRatesModelChoice.FacilityOptionsFeesAndRatesModelChoiceBuilder> getFacilityOptionsFeesAndRatesModelChoice();
		AccruingPikOption.AccruingPikOptionBuilder getOrCreateAccruingPikOption();
		AccruingPikOption.AccruingPikOptionBuilder getAccruingPikOption();
		AccruingFeeOption.AccruingFeeOptionBuilder getOrCreateAccruingFeeOption(int _index);
		List<? extends AccruingFeeOption.AccruingFeeOptionBuilder> getAccruingFeeOption();
		FacilityRatesModel.FacilityRatesModelBuilder getOrCreateFacilityRatesModel();
		FacilityRatesModel.FacilityRatesModelBuilder getFacilityRatesModel();
		FacilityOptionsFeesAndRatesModel.FacilityOptionsFeesAndRatesModelBuilder addFacilityOptionsFeesAndRatesModelChoice(FacilityOptionsFeesAndRatesModelChoice facilityOptionsFeesAndRatesModelChoice0);
		FacilityOptionsFeesAndRatesModel.FacilityOptionsFeesAndRatesModelBuilder addFacilityOptionsFeesAndRatesModelChoice(FacilityOptionsFeesAndRatesModelChoice facilityOptionsFeesAndRatesModelChoice1, int _idx);
		FacilityOptionsFeesAndRatesModel.FacilityOptionsFeesAndRatesModelBuilder addFacilityOptionsFeesAndRatesModelChoice(List<? extends FacilityOptionsFeesAndRatesModelChoice> facilityOptionsFeesAndRatesModelChoice2);
		FacilityOptionsFeesAndRatesModel.FacilityOptionsFeesAndRatesModelBuilder setFacilityOptionsFeesAndRatesModelChoice(List<? extends FacilityOptionsFeesAndRatesModelChoice> facilityOptionsFeesAndRatesModelChoice3);
		FacilityOptionsFeesAndRatesModel.FacilityOptionsFeesAndRatesModelBuilder setAccruingPikOption(AccruingPikOption accruingPikOption);
		FacilityOptionsFeesAndRatesModel.FacilityOptionsFeesAndRatesModelBuilder addAccruingFeeOption(AccruingFeeOption accruingFeeOption0);
		FacilityOptionsFeesAndRatesModel.FacilityOptionsFeesAndRatesModelBuilder addAccruingFeeOption(AccruingFeeOption accruingFeeOption1, int _idx);
		FacilityOptionsFeesAndRatesModel.FacilityOptionsFeesAndRatesModelBuilder addAccruingFeeOption(List<? extends AccruingFeeOption> accruingFeeOption2);
		FacilityOptionsFeesAndRatesModel.FacilityOptionsFeesAndRatesModelBuilder setAccruingFeeOption(List<? extends AccruingFeeOption> accruingFeeOption3);
		FacilityOptionsFeesAndRatesModel.FacilityOptionsFeesAndRatesModelBuilder setFacilityRatesModel(FacilityRatesModel facilityRatesModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("facilityOptionsFeesAndRatesModelChoice"), processor, FacilityOptionsFeesAndRatesModelChoice.FacilityOptionsFeesAndRatesModelChoiceBuilder.class, getFacilityOptionsFeesAndRatesModelChoice());
			processRosetta(path.newSubPath("accruingPikOption"), processor, AccruingPikOption.AccruingPikOptionBuilder.class, getAccruingPikOption());
			processRosetta(path.newSubPath("accruingFeeOption"), processor, AccruingFeeOption.AccruingFeeOptionBuilder.class, getAccruingFeeOption());
			processRosetta(path.newSubPath("facilityRatesModel"), processor, FacilityRatesModel.FacilityRatesModelBuilder.class, getFacilityRatesModel());
		}
		

		FacilityOptionsFeesAndRatesModel.FacilityOptionsFeesAndRatesModelBuilder prune();
	}

	/*********************** Immutable Implementation of FacilityOptionsFeesAndRatesModel  ***********************/
	class FacilityOptionsFeesAndRatesModelImpl implements FacilityOptionsFeesAndRatesModel {
		private final List<? extends FacilityOptionsFeesAndRatesModelChoice> facilityOptionsFeesAndRatesModelChoice;
		private final AccruingPikOption accruingPikOption;
		private final List<? extends AccruingFeeOption> accruingFeeOption;
		private final FacilityRatesModel facilityRatesModel;
		
		protected FacilityOptionsFeesAndRatesModelImpl(FacilityOptionsFeesAndRatesModel.FacilityOptionsFeesAndRatesModelBuilder builder) {
			this.facilityOptionsFeesAndRatesModelChoice = ofNullable(builder.getFacilityOptionsFeesAndRatesModelChoice()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.accruingPikOption = ofNullable(builder.getAccruingPikOption()).map(f->f.build()).orElse(null);
			this.accruingFeeOption = ofNullable(builder.getAccruingFeeOption()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.facilityRatesModel = ofNullable(builder.getFacilityRatesModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("facilityOptionsFeesAndRatesModelChoice")
		public List<? extends FacilityOptionsFeesAndRatesModelChoice> getFacilityOptionsFeesAndRatesModelChoice() {
			return facilityOptionsFeesAndRatesModelChoice;
		}
		
		@Override
		@RosettaAttribute("accruingPikOption")
		public AccruingPikOption getAccruingPikOption() {
			return accruingPikOption;
		}
		
		@Override
		@RosettaAttribute("accruingFeeOption")
		public List<? extends AccruingFeeOption> getAccruingFeeOption() {
			return accruingFeeOption;
		}
		
		@Override
		@RosettaAttribute("facilityRatesModel")
		public FacilityRatesModel getFacilityRatesModel() {
			return facilityRatesModel;
		}
		
		@Override
		public FacilityOptionsFeesAndRatesModel build() {
			return this;
		}
		
		@Override
		public FacilityOptionsFeesAndRatesModel.FacilityOptionsFeesAndRatesModelBuilder toBuilder() {
			FacilityOptionsFeesAndRatesModel.FacilityOptionsFeesAndRatesModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FacilityOptionsFeesAndRatesModel.FacilityOptionsFeesAndRatesModelBuilder builder) {
			ofNullable(getFacilityOptionsFeesAndRatesModelChoice()).ifPresent(builder::setFacilityOptionsFeesAndRatesModelChoice);
			ofNullable(getAccruingPikOption()).ifPresent(builder::setAccruingPikOption);
			ofNullable(getAccruingFeeOption()).ifPresent(builder::setAccruingFeeOption);
			ofNullable(getFacilityRatesModel()).ifPresent(builder::setFacilityRatesModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FacilityOptionsFeesAndRatesModel _that = getType().cast(o);
		
			if (!ListEquals.listEquals(facilityOptionsFeesAndRatesModelChoice, _that.getFacilityOptionsFeesAndRatesModelChoice())) return false;
			if (!Objects.equals(accruingPikOption, _that.getAccruingPikOption())) return false;
			if (!ListEquals.listEquals(accruingFeeOption, _that.getAccruingFeeOption())) return false;
			if (!Objects.equals(facilityRatesModel, _that.getFacilityRatesModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (facilityOptionsFeesAndRatesModelChoice != null ? facilityOptionsFeesAndRatesModelChoice.hashCode() : 0);
			_result = 31 * _result + (accruingPikOption != null ? accruingPikOption.hashCode() : 0);
			_result = 31 * _result + (accruingFeeOption != null ? accruingFeeOption.hashCode() : 0);
			_result = 31 * _result + (facilityRatesModel != null ? facilityRatesModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FacilityOptionsFeesAndRatesModel {" +
				"facilityOptionsFeesAndRatesModelChoice=" + this.facilityOptionsFeesAndRatesModelChoice + ", " +
				"accruingPikOption=" + this.accruingPikOption + ", " +
				"accruingFeeOption=" + this.accruingFeeOption + ", " +
				"facilityRatesModel=" + this.facilityRatesModel +
			'}';
		}
	}

	/*********************** Builder Implementation of FacilityOptionsFeesAndRatesModel  ***********************/
	class FacilityOptionsFeesAndRatesModelBuilderImpl implements FacilityOptionsFeesAndRatesModel.FacilityOptionsFeesAndRatesModelBuilder {
	
		protected List<FacilityOptionsFeesAndRatesModelChoice.FacilityOptionsFeesAndRatesModelChoiceBuilder> facilityOptionsFeesAndRatesModelChoice = new ArrayList<>();
		protected AccruingPikOption.AccruingPikOptionBuilder accruingPikOption;
		protected List<AccruingFeeOption.AccruingFeeOptionBuilder> accruingFeeOption = new ArrayList<>();
		protected FacilityRatesModel.FacilityRatesModelBuilder facilityRatesModel;
	
		public FacilityOptionsFeesAndRatesModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("facilityOptionsFeesAndRatesModelChoice")
		public List<? extends FacilityOptionsFeesAndRatesModelChoice.FacilityOptionsFeesAndRatesModelChoiceBuilder> getFacilityOptionsFeesAndRatesModelChoice() {
			return facilityOptionsFeesAndRatesModelChoice;
		}
		
		public FacilityOptionsFeesAndRatesModelChoice.FacilityOptionsFeesAndRatesModelChoiceBuilder getOrCreateFacilityOptionsFeesAndRatesModelChoice(int _index) {
		
			if (facilityOptionsFeesAndRatesModelChoice==null) {
				this.facilityOptionsFeesAndRatesModelChoice = new ArrayList<>();
			}
			FacilityOptionsFeesAndRatesModelChoice.FacilityOptionsFeesAndRatesModelChoiceBuilder result;
			return getIndex(facilityOptionsFeesAndRatesModelChoice, _index, () -> {
						FacilityOptionsFeesAndRatesModelChoice.FacilityOptionsFeesAndRatesModelChoiceBuilder newFacilityOptionsFeesAndRatesModelChoice = FacilityOptionsFeesAndRatesModelChoice.builder();
						return newFacilityOptionsFeesAndRatesModelChoice;
					});
		}
		
		@Override
		@RosettaAttribute("accruingPikOption")
		public AccruingPikOption.AccruingPikOptionBuilder getAccruingPikOption() {
			return accruingPikOption;
		}
		
		@Override
		public AccruingPikOption.AccruingPikOptionBuilder getOrCreateAccruingPikOption() {
			AccruingPikOption.AccruingPikOptionBuilder result;
			if (accruingPikOption!=null) {
				result = accruingPikOption;
			}
			else {
				result = accruingPikOption = AccruingPikOption.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("accruingFeeOption")
		public List<? extends AccruingFeeOption.AccruingFeeOptionBuilder> getAccruingFeeOption() {
			return accruingFeeOption;
		}
		
		public AccruingFeeOption.AccruingFeeOptionBuilder getOrCreateAccruingFeeOption(int _index) {
		
			if (accruingFeeOption==null) {
				this.accruingFeeOption = new ArrayList<>();
			}
			AccruingFeeOption.AccruingFeeOptionBuilder result;
			return getIndex(accruingFeeOption, _index, () -> {
						AccruingFeeOption.AccruingFeeOptionBuilder newAccruingFeeOption = AccruingFeeOption.builder();
						return newAccruingFeeOption;
					});
		}
		
		@Override
		@RosettaAttribute("facilityRatesModel")
		public FacilityRatesModel.FacilityRatesModelBuilder getFacilityRatesModel() {
			return facilityRatesModel;
		}
		
		@Override
		public FacilityRatesModel.FacilityRatesModelBuilder getOrCreateFacilityRatesModel() {
			FacilityRatesModel.FacilityRatesModelBuilder result;
			if (facilityRatesModel!=null) {
				result = facilityRatesModel;
			}
			else {
				result = facilityRatesModel = FacilityRatesModel.builder();
			}
			
			return result;
		}
		
		@Override
		public FacilityOptionsFeesAndRatesModel.FacilityOptionsFeesAndRatesModelBuilder addFacilityOptionsFeesAndRatesModelChoice(FacilityOptionsFeesAndRatesModelChoice facilityOptionsFeesAndRatesModelChoice) {
			if (facilityOptionsFeesAndRatesModelChoice!=null) this.facilityOptionsFeesAndRatesModelChoice.add(facilityOptionsFeesAndRatesModelChoice.toBuilder());
			return this;
		}
		
		@Override
		public FacilityOptionsFeesAndRatesModel.FacilityOptionsFeesAndRatesModelBuilder addFacilityOptionsFeesAndRatesModelChoice(FacilityOptionsFeesAndRatesModelChoice facilityOptionsFeesAndRatesModelChoice, int _idx) {
			getIndex(this.facilityOptionsFeesAndRatesModelChoice, _idx, () -> facilityOptionsFeesAndRatesModelChoice.toBuilder());
			return this;
		}
		@Override 
		public FacilityOptionsFeesAndRatesModel.FacilityOptionsFeesAndRatesModelBuilder addFacilityOptionsFeesAndRatesModelChoice(List<? extends FacilityOptionsFeesAndRatesModelChoice> facilityOptionsFeesAndRatesModelChoices) {
			if (facilityOptionsFeesAndRatesModelChoices != null) {
				for (FacilityOptionsFeesAndRatesModelChoice toAdd : facilityOptionsFeesAndRatesModelChoices) {
					this.facilityOptionsFeesAndRatesModelChoice.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("facilityOptionsFeesAndRatesModelChoice")
		public FacilityOptionsFeesAndRatesModel.FacilityOptionsFeesAndRatesModelBuilder setFacilityOptionsFeesAndRatesModelChoice(List<? extends FacilityOptionsFeesAndRatesModelChoice> facilityOptionsFeesAndRatesModelChoices) {
			if (facilityOptionsFeesAndRatesModelChoices == null)  {
				this.facilityOptionsFeesAndRatesModelChoice = new ArrayList<>();
			}
			else {
				this.facilityOptionsFeesAndRatesModelChoice = facilityOptionsFeesAndRatesModelChoices.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("accruingPikOption")
		public FacilityOptionsFeesAndRatesModel.FacilityOptionsFeesAndRatesModelBuilder setAccruingPikOption(AccruingPikOption accruingPikOption) {
			this.accruingPikOption = accruingPikOption==null?null:accruingPikOption.toBuilder();
			return this;
		}
		@Override
		public FacilityOptionsFeesAndRatesModel.FacilityOptionsFeesAndRatesModelBuilder addAccruingFeeOption(AccruingFeeOption accruingFeeOption) {
			if (accruingFeeOption!=null) this.accruingFeeOption.add(accruingFeeOption.toBuilder());
			return this;
		}
		
		@Override
		public FacilityOptionsFeesAndRatesModel.FacilityOptionsFeesAndRatesModelBuilder addAccruingFeeOption(AccruingFeeOption accruingFeeOption, int _idx) {
			getIndex(this.accruingFeeOption, _idx, () -> accruingFeeOption.toBuilder());
			return this;
		}
		@Override 
		public FacilityOptionsFeesAndRatesModel.FacilityOptionsFeesAndRatesModelBuilder addAccruingFeeOption(List<? extends AccruingFeeOption> accruingFeeOptions) {
			if (accruingFeeOptions != null) {
				for (AccruingFeeOption toAdd : accruingFeeOptions) {
					this.accruingFeeOption.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("accruingFeeOption")
		public FacilityOptionsFeesAndRatesModel.FacilityOptionsFeesAndRatesModelBuilder setAccruingFeeOption(List<? extends AccruingFeeOption> accruingFeeOptions) {
			if (accruingFeeOptions == null)  {
				this.accruingFeeOption = new ArrayList<>();
			}
			else {
				this.accruingFeeOption = accruingFeeOptions.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("facilityRatesModel")
		public FacilityOptionsFeesAndRatesModel.FacilityOptionsFeesAndRatesModelBuilder setFacilityRatesModel(FacilityRatesModel facilityRatesModel) {
			this.facilityRatesModel = facilityRatesModel==null?null:facilityRatesModel.toBuilder();
			return this;
		}
		
		@Override
		public FacilityOptionsFeesAndRatesModel build() {
			return new FacilityOptionsFeesAndRatesModel.FacilityOptionsFeesAndRatesModelImpl(this);
		}
		
		@Override
		public FacilityOptionsFeesAndRatesModel.FacilityOptionsFeesAndRatesModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FacilityOptionsFeesAndRatesModel.FacilityOptionsFeesAndRatesModelBuilder prune() {
			facilityOptionsFeesAndRatesModelChoice = facilityOptionsFeesAndRatesModelChoice.stream().filter(b->b!=null).<FacilityOptionsFeesAndRatesModelChoice.FacilityOptionsFeesAndRatesModelChoiceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (accruingPikOption!=null && !accruingPikOption.prune().hasData()) accruingPikOption = null;
			accruingFeeOption = accruingFeeOption.stream().filter(b->b!=null).<AccruingFeeOption.AccruingFeeOptionBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (facilityRatesModel!=null && !facilityRatesModel.prune().hasData()) facilityRatesModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFacilityOptionsFeesAndRatesModelChoice()!=null && getFacilityOptionsFeesAndRatesModelChoice().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getAccruingPikOption()!=null && getAccruingPikOption().hasData()) return true;
			if (getAccruingFeeOption()!=null && getAccruingFeeOption().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getFacilityRatesModel()!=null && getFacilityRatesModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FacilityOptionsFeesAndRatesModel.FacilityOptionsFeesAndRatesModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FacilityOptionsFeesAndRatesModel.FacilityOptionsFeesAndRatesModelBuilder o = (FacilityOptionsFeesAndRatesModel.FacilityOptionsFeesAndRatesModelBuilder) other;
			
			merger.mergeRosetta(getFacilityOptionsFeesAndRatesModelChoice(), o.getFacilityOptionsFeesAndRatesModelChoice(), this::getOrCreateFacilityOptionsFeesAndRatesModelChoice);
			merger.mergeRosetta(getAccruingPikOption(), o.getAccruingPikOption(), this::setAccruingPikOption);
			merger.mergeRosetta(getAccruingFeeOption(), o.getAccruingFeeOption(), this::getOrCreateAccruingFeeOption);
			merger.mergeRosetta(getFacilityRatesModel(), o.getFacilityRatesModel(), this::setFacilityRatesModel);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FacilityOptionsFeesAndRatesModel _that = getType().cast(o);
		
			if (!ListEquals.listEquals(facilityOptionsFeesAndRatesModelChoice, _that.getFacilityOptionsFeesAndRatesModelChoice())) return false;
			if (!Objects.equals(accruingPikOption, _that.getAccruingPikOption())) return false;
			if (!ListEquals.listEquals(accruingFeeOption, _that.getAccruingFeeOption())) return false;
			if (!Objects.equals(facilityRatesModel, _that.getFacilityRatesModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (facilityOptionsFeesAndRatesModelChoice != null ? facilityOptionsFeesAndRatesModelChoice.hashCode() : 0);
			_result = 31 * _result + (accruingPikOption != null ? accruingPikOption.hashCode() : 0);
			_result = 31 * _result + (accruingFeeOption != null ? accruingFeeOption.hashCode() : 0);
			_result = 31 * _result + (facilityRatesModel != null ? facilityRatesModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FacilityOptionsFeesAndRatesModelBuilder {" +
				"facilityOptionsFeesAndRatesModelChoice=" + this.facilityOptionsFeesAndRatesModelChoice + ", " +
				"accruingPikOption=" + this.accruingPikOption + ", " +
				"accruingFeeOption=" + this.accruingFeeOption + ", " +
				"facilityRatesModel=" + this.facilityRatesModel +
			'}';
		}
	}
}
