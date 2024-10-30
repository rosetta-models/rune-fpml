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
import fpml.confirmation.Quotation;
import fpml.confirmation.Quotation.QuotationBuilder;
import fpml.confirmation.Quotation.QuotationBuilderImpl;
import fpml.confirmation.Quotation.QuotationImpl;
import fpml.confirmation.QuotationModel;
import fpml.confirmation.SensitivitySet;
import fpml.confirmation.meta.QuotationMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Some kind of numerical measure about an asset, eg. its NPV, together with characteristics of that measure, together with optional sensitivities.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="Quotation", builder=Quotation.QuotationBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface Quotation extends RosettaModelObject {

	QuotationMeta metaData = new QuotationMeta();

	/*********************** Getter Methods  ***********************/
	QuotationModel getQuotationModel();
	/**
	 * Zero or more sets of sensitivities of this measure to various input parameters.
	 */
	List<? extends SensitivitySet> getSensitivitySet();

	/*********************** Build Methods  ***********************/
	Quotation build();
	
	Quotation.QuotationBuilder toBuilder();
	
	static Quotation.QuotationBuilder builder() {
		return new Quotation.QuotationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Quotation> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Quotation> getType() {
		return Quotation.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("quotationModel"), processor, QuotationModel.class, getQuotationModel());
		processRosetta(path.newSubPath("sensitivitySet"), processor, SensitivitySet.class, getSensitivitySet());
	}
	

	/*********************** Builder Interface  ***********************/
	interface QuotationBuilder extends Quotation, RosettaModelObjectBuilder {
		QuotationModel.QuotationModelBuilder getOrCreateQuotationModel();
		QuotationModel.QuotationModelBuilder getQuotationModel();
		SensitivitySet.SensitivitySetBuilder getOrCreateSensitivitySet(int _index);
		List<? extends SensitivitySet.SensitivitySetBuilder> getSensitivitySet();
		Quotation.QuotationBuilder setQuotationModel(QuotationModel quotationModel);
		Quotation.QuotationBuilder addSensitivitySet(SensitivitySet sensitivitySet0);
		Quotation.QuotationBuilder addSensitivitySet(SensitivitySet sensitivitySet1, int _idx);
		Quotation.QuotationBuilder addSensitivitySet(List<? extends SensitivitySet> sensitivitySet2);
		Quotation.QuotationBuilder setSensitivitySet(List<? extends SensitivitySet> sensitivitySet3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("quotationModel"), processor, QuotationModel.QuotationModelBuilder.class, getQuotationModel());
			processRosetta(path.newSubPath("sensitivitySet"), processor, SensitivitySet.SensitivitySetBuilder.class, getSensitivitySet());
		}
		

		Quotation.QuotationBuilder prune();
	}

	/*********************** Immutable Implementation of Quotation  ***********************/
	class QuotationImpl implements Quotation {
		private final QuotationModel quotationModel;
		private final List<? extends SensitivitySet> sensitivitySet;
		
		protected QuotationImpl(Quotation.QuotationBuilder builder) {
			this.quotationModel = ofNullable(builder.getQuotationModel()).map(f->f.build()).orElse(null);
			this.sensitivitySet = ofNullable(builder.getSensitivitySet()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("quotationModel")
		public QuotationModel getQuotationModel() {
			return quotationModel;
		}
		
		@Override
		@RosettaAttribute("sensitivitySet")
		public List<? extends SensitivitySet> getSensitivitySet() {
			return sensitivitySet;
		}
		
		@Override
		public Quotation build() {
			return this;
		}
		
		@Override
		public Quotation.QuotationBuilder toBuilder() {
			Quotation.QuotationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Quotation.QuotationBuilder builder) {
			ofNullable(getQuotationModel()).ifPresent(builder::setQuotationModel);
			ofNullable(getSensitivitySet()).ifPresent(builder::setSensitivitySet);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Quotation _that = getType().cast(o);
		
			if (!Objects.equals(quotationModel, _that.getQuotationModel())) return false;
			if (!ListEquals.listEquals(sensitivitySet, _that.getSensitivitySet())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (quotationModel != null ? quotationModel.hashCode() : 0);
			_result = 31 * _result + (sensitivitySet != null ? sensitivitySet.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Quotation {" +
				"quotationModel=" + this.quotationModel + ", " +
				"sensitivitySet=" + this.sensitivitySet +
			'}';
		}
	}

	/*********************** Builder Implementation of Quotation  ***********************/
	class QuotationBuilderImpl implements Quotation.QuotationBuilder {
	
		protected QuotationModel.QuotationModelBuilder quotationModel;
		protected List<SensitivitySet.SensitivitySetBuilder> sensitivitySet = new ArrayList<>();
	
		public QuotationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("quotationModel")
		public QuotationModel.QuotationModelBuilder getQuotationModel() {
			return quotationModel;
		}
		
		@Override
		public QuotationModel.QuotationModelBuilder getOrCreateQuotationModel() {
			QuotationModel.QuotationModelBuilder result;
			if (quotationModel!=null) {
				result = quotationModel;
			}
			else {
				result = quotationModel = QuotationModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("sensitivitySet")
		public List<? extends SensitivitySet.SensitivitySetBuilder> getSensitivitySet() {
			return sensitivitySet;
		}
		
		@Override
		public SensitivitySet.SensitivitySetBuilder getOrCreateSensitivitySet(int _index) {
		
			if (sensitivitySet==null) {
				this.sensitivitySet = new ArrayList<>();
			}
			SensitivitySet.SensitivitySetBuilder result;
			return getIndex(sensitivitySet, _index, () -> {
						SensitivitySet.SensitivitySetBuilder newSensitivitySet = SensitivitySet.builder();
						return newSensitivitySet;
					});
		}
		
		@Override
		@RosettaAttribute("quotationModel")
		public Quotation.QuotationBuilder setQuotationModel(QuotationModel quotationModel) {
			this.quotationModel = quotationModel==null?null:quotationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("sensitivitySet")
		public Quotation.QuotationBuilder addSensitivitySet(SensitivitySet sensitivitySet) {
			if (sensitivitySet!=null) this.sensitivitySet.add(sensitivitySet.toBuilder());
			return this;
		}
		
		@Override
		public Quotation.QuotationBuilder addSensitivitySet(SensitivitySet sensitivitySet, int _idx) {
			getIndex(this.sensitivitySet, _idx, () -> sensitivitySet.toBuilder());
			return this;
		}
		@Override 
		public Quotation.QuotationBuilder addSensitivitySet(List<? extends SensitivitySet> sensitivitySets) {
			if (sensitivitySets != null) {
				for (SensitivitySet toAdd : sensitivitySets) {
					this.sensitivitySet.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public Quotation.QuotationBuilder setSensitivitySet(List<? extends SensitivitySet> sensitivitySets) {
			if (sensitivitySets == null)  {
				this.sensitivitySet = new ArrayList<>();
			}
			else {
				this.sensitivitySet = sensitivitySets.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public Quotation build() {
			return new Quotation.QuotationImpl(this);
		}
		
		@Override
		public Quotation.QuotationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Quotation.QuotationBuilder prune() {
			if (quotationModel!=null && !quotationModel.prune().hasData()) quotationModel = null;
			sensitivitySet = sensitivitySet.stream().filter(b->b!=null).<SensitivitySet.SensitivitySetBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getQuotationModel()!=null && getQuotationModel().hasData()) return true;
			if (getSensitivitySet()!=null && getSensitivitySet().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Quotation.QuotationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Quotation.QuotationBuilder o = (Quotation.QuotationBuilder) other;
			
			merger.mergeRosetta(getQuotationModel(), o.getQuotationModel(), this::setQuotationModel);
			merger.mergeRosetta(getSensitivitySet(), o.getSensitivitySet(), this::getOrCreateSensitivitySet);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Quotation _that = getType().cast(o);
		
			if (!Objects.equals(quotationModel, _that.getQuotationModel())) return false;
			if (!ListEquals.listEquals(sensitivitySet, _that.getSensitivitySet())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (quotationModel != null ? quotationModel.hashCode() : 0);
			_result = 31 * _result + (sensitivitySet != null ? sensitivitySet.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "QuotationBuilder {" +
				"quotationModel=" + this.quotationModel + ", " +
				"sensitivitySet=" + this.sensitivitySet +
			'}';
		}
	}
}
