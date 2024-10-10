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
import fpml.confirmation.PricingCoordinateOrReferenceModel;
import fpml.confirmation.SensitivityDescriptionModel;
import fpml.confirmation.SensitivityDescriptionModel.SensitivityDescriptionModelBuilder;
import fpml.confirmation.SensitivityDescriptionModel.SensitivityDescriptionModelBuilderImpl;
import fpml.confirmation.SensitivityDescriptionModel.SensitivityDescriptionModelImpl;
import fpml.confirmation.TimeDimension;
import fpml.confirmation.meta.SensitivityDescriptionModelMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="SensitivityDescriptionModel", builder=SensitivityDescriptionModel.SensitivityDescriptionModelBuilderImpl.class, version="${project.version}")
public interface SensitivityDescriptionModel extends RosettaModelObject {

	SensitivityDescriptionModelMeta metaData = new SensitivityDescriptionModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The time dimension of the sensitivity point (tenor and/or date).
	 */
	TimeDimension getTerm();
	List<? extends PricingCoordinateOrReferenceModel> getPricingCoordinateOrReferenceModel();

	/*********************** Build Methods  ***********************/
	SensitivityDescriptionModel build();
	
	SensitivityDescriptionModel.SensitivityDescriptionModelBuilder toBuilder();
	
	static SensitivityDescriptionModel.SensitivityDescriptionModelBuilder builder() {
		return new SensitivityDescriptionModel.SensitivityDescriptionModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SensitivityDescriptionModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends SensitivityDescriptionModel> getType() {
		return SensitivityDescriptionModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("term"), processor, TimeDimension.class, getTerm());
		processRosetta(path.newSubPath("pricingCoordinateOrReferenceModel"), processor, PricingCoordinateOrReferenceModel.class, getPricingCoordinateOrReferenceModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface SensitivityDescriptionModelBuilder extends SensitivityDescriptionModel, RosettaModelObjectBuilder {
		TimeDimension.TimeDimensionBuilder getOrCreateTerm();
		TimeDimension.TimeDimensionBuilder getTerm();
		PricingCoordinateOrReferenceModel.PricingCoordinateOrReferenceModelBuilder getOrCreatePricingCoordinateOrReferenceModel(int _index);
		List<? extends PricingCoordinateOrReferenceModel.PricingCoordinateOrReferenceModelBuilder> getPricingCoordinateOrReferenceModel();
		SensitivityDescriptionModel.SensitivityDescriptionModelBuilder setTerm(TimeDimension term);
		SensitivityDescriptionModel.SensitivityDescriptionModelBuilder addPricingCoordinateOrReferenceModel(PricingCoordinateOrReferenceModel pricingCoordinateOrReferenceModel0);
		SensitivityDescriptionModel.SensitivityDescriptionModelBuilder addPricingCoordinateOrReferenceModel(PricingCoordinateOrReferenceModel pricingCoordinateOrReferenceModel1, int _idx);
		SensitivityDescriptionModel.SensitivityDescriptionModelBuilder addPricingCoordinateOrReferenceModel(List<? extends PricingCoordinateOrReferenceModel> pricingCoordinateOrReferenceModel2);
		SensitivityDescriptionModel.SensitivityDescriptionModelBuilder setPricingCoordinateOrReferenceModel(List<? extends PricingCoordinateOrReferenceModel> pricingCoordinateOrReferenceModel3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("term"), processor, TimeDimension.TimeDimensionBuilder.class, getTerm());
			processRosetta(path.newSubPath("pricingCoordinateOrReferenceModel"), processor, PricingCoordinateOrReferenceModel.PricingCoordinateOrReferenceModelBuilder.class, getPricingCoordinateOrReferenceModel());
		}
		

		SensitivityDescriptionModel.SensitivityDescriptionModelBuilder prune();
	}

	/*********************** Immutable Implementation of SensitivityDescriptionModel  ***********************/
	class SensitivityDescriptionModelImpl implements SensitivityDescriptionModel {
		private final TimeDimension term;
		private final List<? extends PricingCoordinateOrReferenceModel> pricingCoordinateOrReferenceModel;
		
		protected SensitivityDescriptionModelImpl(SensitivityDescriptionModel.SensitivityDescriptionModelBuilder builder) {
			this.term = ofNullable(builder.getTerm()).map(f->f.build()).orElse(null);
			this.pricingCoordinateOrReferenceModel = ofNullable(builder.getPricingCoordinateOrReferenceModel()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("term")
		public TimeDimension getTerm() {
			return term;
		}
		
		@Override
		@RosettaAttribute("pricingCoordinateOrReferenceModel")
		public List<? extends PricingCoordinateOrReferenceModel> getPricingCoordinateOrReferenceModel() {
			return pricingCoordinateOrReferenceModel;
		}
		
		@Override
		public SensitivityDescriptionModel build() {
			return this;
		}
		
		@Override
		public SensitivityDescriptionModel.SensitivityDescriptionModelBuilder toBuilder() {
			SensitivityDescriptionModel.SensitivityDescriptionModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SensitivityDescriptionModel.SensitivityDescriptionModelBuilder builder) {
			ofNullable(getTerm()).ifPresent(builder::setTerm);
			ofNullable(getPricingCoordinateOrReferenceModel()).ifPresent(builder::setPricingCoordinateOrReferenceModel);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SensitivityDescriptionModel _that = getType().cast(o);
		
			if (!Objects.equals(term, _that.getTerm())) return false;
			if (!ListEquals.listEquals(pricingCoordinateOrReferenceModel, _that.getPricingCoordinateOrReferenceModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (term != null ? term.hashCode() : 0);
			_result = 31 * _result + (pricingCoordinateOrReferenceModel != null ? pricingCoordinateOrReferenceModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SensitivityDescriptionModel {" +
				"term=" + this.term + ", " +
				"pricingCoordinateOrReferenceModel=" + this.pricingCoordinateOrReferenceModel +
			'}';
		}
	}

	/*********************** Builder Implementation of SensitivityDescriptionModel  ***********************/
	class SensitivityDescriptionModelBuilderImpl implements SensitivityDescriptionModel.SensitivityDescriptionModelBuilder {
	
		protected TimeDimension.TimeDimensionBuilder term;
		protected List<PricingCoordinateOrReferenceModel.PricingCoordinateOrReferenceModelBuilder> pricingCoordinateOrReferenceModel = new ArrayList<>();
	
		public SensitivityDescriptionModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("term")
		public TimeDimension.TimeDimensionBuilder getTerm() {
			return term;
		}
		
		@Override
		public TimeDimension.TimeDimensionBuilder getOrCreateTerm() {
			TimeDimension.TimeDimensionBuilder result;
			if (term!=null) {
				result = term;
			}
			else {
				result = term = TimeDimension.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("pricingCoordinateOrReferenceModel")
		public List<? extends PricingCoordinateOrReferenceModel.PricingCoordinateOrReferenceModelBuilder> getPricingCoordinateOrReferenceModel() {
			return pricingCoordinateOrReferenceModel;
		}
		
		public PricingCoordinateOrReferenceModel.PricingCoordinateOrReferenceModelBuilder getOrCreatePricingCoordinateOrReferenceModel(int _index) {
		
			if (pricingCoordinateOrReferenceModel==null) {
				this.pricingCoordinateOrReferenceModel = new ArrayList<>();
			}
			PricingCoordinateOrReferenceModel.PricingCoordinateOrReferenceModelBuilder result;
			return getIndex(pricingCoordinateOrReferenceModel, _index, () -> {
						PricingCoordinateOrReferenceModel.PricingCoordinateOrReferenceModelBuilder newPricingCoordinateOrReferenceModel = PricingCoordinateOrReferenceModel.builder();
						return newPricingCoordinateOrReferenceModel;
					});
		}
		
		@Override
		@RosettaAttribute("term")
		public SensitivityDescriptionModel.SensitivityDescriptionModelBuilder setTerm(TimeDimension term) {
			this.term = term==null?null:term.toBuilder();
			return this;
		}
		@Override
		public SensitivityDescriptionModel.SensitivityDescriptionModelBuilder addPricingCoordinateOrReferenceModel(PricingCoordinateOrReferenceModel pricingCoordinateOrReferenceModel) {
			if (pricingCoordinateOrReferenceModel!=null) this.pricingCoordinateOrReferenceModel.add(pricingCoordinateOrReferenceModel.toBuilder());
			return this;
		}
		
		@Override
		public SensitivityDescriptionModel.SensitivityDescriptionModelBuilder addPricingCoordinateOrReferenceModel(PricingCoordinateOrReferenceModel pricingCoordinateOrReferenceModel, int _idx) {
			getIndex(this.pricingCoordinateOrReferenceModel, _idx, () -> pricingCoordinateOrReferenceModel.toBuilder());
			return this;
		}
		@Override 
		public SensitivityDescriptionModel.SensitivityDescriptionModelBuilder addPricingCoordinateOrReferenceModel(List<? extends PricingCoordinateOrReferenceModel> pricingCoordinateOrReferenceModels) {
			if (pricingCoordinateOrReferenceModels != null) {
				for (PricingCoordinateOrReferenceModel toAdd : pricingCoordinateOrReferenceModels) {
					this.pricingCoordinateOrReferenceModel.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("pricingCoordinateOrReferenceModel")
		public SensitivityDescriptionModel.SensitivityDescriptionModelBuilder setPricingCoordinateOrReferenceModel(List<? extends PricingCoordinateOrReferenceModel> pricingCoordinateOrReferenceModels) {
			if (pricingCoordinateOrReferenceModels == null)  {
				this.pricingCoordinateOrReferenceModel = new ArrayList<>();
			}
			else {
				this.pricingCoordinateOrReferenceModel = pricingCoordinateOrReferenceModels.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public SensitivityDescriptionModel build() {
			return new SensitivityDescriptionModel.SensitivityDescriptionModelImpl(this);
		}
		
		@Override
		public SensitivityDescriptionModel.SensitivityDescriptionModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SensitivityDescriptionModel.SensitivityDescriptionModelBuilder prune() {
			if (term!=null && !term.prune().hasData()) term = null;
			pricingCoordinateOrReferenceModel = pricingCoordinateOrReferenceModel.stream().filter(b->b!=null).<PricingCoordinateOrReferenceModel.PricingCoordinateOrReferenceModelBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTerm()!=null && getTerm().hasData()) return true;
			if (getPricingCoordinateOrReferenceModel()!=null && getPricingCoordinateOrReferenceModel().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SensitivityDescriptionModel.SensitivityDescriptionModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SensitivityDescriptionModel.SensitivityDescriptionModelBuilder o = (SensitivityDescriptionModel.SensitivityDescriptionModelBuilder) other;
			
			merger.mergeRosetta(getTerm(), o.getTerm(), this::setTerm);
			merger.mergeRosetta(getPricingCoordinateOrReferenceModel(), o.getPricingCoordinateOrReferenceModel(), this::getOrCreatePricingCoordinateOrReferenceModel);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SensitivityDescriptionModel _that = getType().cast(o);
		
			if (!Objects.equals(term, _that.getTerm())) return false;
			if (!ListEquals.listEquals(pricingCoordinateOrReferenceModel, _that.getPricingCoordinateOrReferenceModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (term != null ? term.hashCode() : 0);
			_result = 31 * _result + (pricingCoordinateOrReferenceModel != null ? pricingCoordinateOrReferenceModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SensitivityDescriptionModelBuilder {" +
				"term=" + this.term + ", " +
				"pricingCoordinateOrReferenceModel=" + this.pricingCoordinateOrReferenceModel +
			'}';
		}
	}
}
