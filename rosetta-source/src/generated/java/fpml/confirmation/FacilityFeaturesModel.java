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
import fpml.confirmation.CreditSeniority;
import fpml.confirmation.FacilityFeature;
import fpml.confirmation.FacilityFeaturesModel;
import fpml.confirmation.FacilityFeaturesModel.FacilityFeaturesModelBuilder;
import fpml.confirmation.FacilityFeaturesModel.FacilityFeaturesModelBuilderImpl;
import fpml.confirmation.FacilityFeaturesModel.FacilityFeaturesModelImpl;
import fpml.confirmation.Lien;
import fpml.confirmation.meta.FacilityFeaturesModelMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A model that describes features/attributes associated with a given facility.
 * @version ${project.version}
 */
@RosettaDataType(value="FacilityFeaturesModel", builder=FacilityFeaturesModel.FacilityFeaturesModelBuilderImpl.class, version="${project.version}")
public interface FacilityFeaturesModel extends RosettaModelObject {

	FacilityFeaturesModelMeta metaData = new FacilityFeaturesModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Facility features which help define the instrument with greater granularity. E.g. bridge, acquisition etc.
	 */
	List<? extends FacilityFeature> getFeature();
	/**
	 * The lien level associated with the facility. E.g. 1st, 2nd, 3rd.
	 */
	Lien getLien();
	/**
	 * The seniority of the facility. E.g. senior, senior secured etc.
	 */
	CreditSeniority getSeniority();

	/*********************** Build Methods  ***********************/
	FacilityFeaturesModel build();
	
	FacilityFeaturesModel.FacilityFeaturesModelBuilder toBuilder();
	
	static FacilityFeaturesModel.FacilityFeaturesModelBuilder builder() {
		return new FacilityFeaturesModel.FacilityFeaturesModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FacilityFeaturesModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FacilityFeaturesModel> getType() {
		return FacilityFeaturesModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("feature"), processor, FacilityFeature.class, getFeature());
		processRosetta(path.newSubPath("lien"), processor, Lien.class, getLien());
		processRosetta(path.newSubPath("seniority"), processor, CreditSeniority.class, getSeniority());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FacilityFeaturesModelBuilder extends FacilityFeaturesModel, RosettaModelObjectBuilder {
		FacilityFeature.FacilityFeatureBuilder getOrCreateFeature(int _index);
		List<? extends FacilityFeature.FacilityFeatureBuilder> getFeature();
		Lien.LienBuilder getOrCreateLien();
		Lien.LienBuilder getLien();
		CreditSeniority.CreditSeniorityBuilder getOrCreateSeniority();
		CreditSeniority.CreditSeniorityBuilder getSeniority();
		FacilityFeaturesModel.FacilityFeaturesModelBuilder addFeature(FacilityFeature feature0);
		FacilityFeaturesModel.FacilityFeaturesModelBuilder addFeature(FacilityFeature feature1, int _idx);
		FacilityFeaturesModel.FacilityFeaturesModelBuilder addFeature(List<? extends FacilityFeature> feature2);
		FacilityFeaturesModel.FacilityFeaturesModelBuilder setFeature(List<? extends FacilityFeature> feature3);
		FacilityFeaturesModel.FacilityFeaturesModelBuilder setLien(Lien lien);
		FacilityFeaturesModel.FacilityFeaturesModelBuilder setSeniority(CreditSeniority seniority);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("feature"), processor, FacilityFeature.FacilityFeatureBuilder.class, getFeature());
			processRosetta(path.newSubPath("lien"), processor, Lien.LienBuilder.class, getLien());
			processRosetta(path.newSubPath("seniority"), processor, CreditSeniority.CreditSeniorityBuilder.class, getSeniority());
		}
		

		FacilityFeaturesModel.FacilityFeaturesModelBuilder prune();
	}

	/*********************** Immutable Implementation of FacilityFeaturesModel  ***********************/
	class FacilityFeaturesModelImpl implements FacilityFeaturesModel {
		private final List<? extends FacilityFeature> feature;
		private final Lien lien;
		private final CreditSeniority seniority;
		
		protected FacilityFeaturesModelImpl(FacilityFeaturesModel.FacilityFeaturesModelBuilder builder) {
			this.feature = ofNullable(builder.getFeature()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.lien = ofNullable(builder.getLien()).map(f->f.build()).orElse(null);
			this.seniority = ofNullable(builder.getSeniority()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("feature")
		public List<? extends FacilityFeature> getFeature() {
			return feature;
		}
		
		@Override
		@RosettaAttribute("lien")
		public Lien getLien() {
			return lien;
		}
		
		@Override
		@RosettaAttribute("seniority")
		public CreditSeniority getSeniority() {
			return seniority;
		}
		
		@Override
		public FacilityFeaturesModel build() {
			return this;
		}
		
		@Override
		public FacilityFeaturesModel.FacilityFeaturesModelBuilder toBuilder() {
			FacilityFeaturesModel.FacilityFeaturesModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FacilityFeaturesModel.FacilityFeaturesModelBuilder builder) {
			ofNullable(getFeature()).ifPresent(builder::setFeature);
			ofNullable(getLien()).ifPresent(builder::setLien);
			ofNullable(getSeniority()).ifPresent(builder::setSeniority);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FacilityFeaturesModel _that = getType().cast(o);
		
			if (!ListEquals.listEquals(feature, _that.getFeature())) return false;
			if (!Objects.equals(lien, _that.getLien())) return false;
			if (!Objects.equals(seniority, _that.getSeniority())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (feature != null ? feature.hashCode() : 0);
			_result = 31 * _result + (lien != null ? lien.hashCode() : 0);
			_result = 31 * _result + (seniority != null ? seniority.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FacilityFeaturesModel {" +
				"feature=" + this.feature + ", " +
				"lien=" + this.lien + ", " +
				"seniority=" + this.seniority +
			'}';
		}
	}

	/*********************** Builder Implementation of FacilityFeaturesModel  ***********************/
	class FacilityFeaturesModelBuilderImpl implements FacilityFeaturesModel.FacilityFeaturesModelBuilder {
	
		protected List<FacilityFeature.FacilityFeatureBuilder> feature = new ArrayList<>();
		protected Lien.LienBuilder lien;
		protected CreditSeniority.CreditSeniorityBuilder seniority;
	
		public FacilityFeaturesModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("feature")
		public List<? extends FacilityFeature.FacilityFeatureBuilder> getFeature() {
			return feature;
		}
		
		public FacilityFeature.FacilityFeatureBuilder getOrCreateFeature(int _index) {
		
			if (feature==null) {
				this.feature = new ArrayList<>();
			}
			FacilityFeature.FacilityFeatureBuilder result;
			return getIndex(feature, _index, () -> {
						FacilityFeature.FacilityFeatureBuilder newFeature = FacilityFeature.builder();
						return newFeature;
					});
		}
		
		@Override
		@RosettaAttribute("lien")
		public Lien.LienBuilder getLien() {
			return lien;
		}
		
		@Override
		public Lien.LienBuilder getOrCreateLien() {
			Lien.LienBuilder result;
			if (lien!=null) {
				result = lien;
			}
			else {
				result = lien = Lien.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("seniority")
		public CreditSeniority.CreditSeniorityBuilder getSeniority() {
			return seniority;
		}
		
		@Override
		public CreditSeniority.CreditSeniorityBuilder getOrCreateSeniority() {
			CreditSeniority.CreditSeniorityBuilder result;
			if (seniority!=null) {
				result = seniority;
			}
			else {
				result = seniority = CreditSeniority.builder();
			}
			
			return result;
		}
		
		@Override
		public FacilityFeaturesModel.FacilityFeaturesModelBuilder addFeature(FacilityFeature feature) {
			if (feature!=null) this.feature.add(feature.toBuilder());
			return this;
		}
		
		@Override
		public FacilityFeaturesModel.FacilityFeaturesModelBuilder addFeature(FacilityFeature feature, int _idx) {
			getIndex(this.feature, _idx, () -> feature.toBuilder());
			return this;
		}
		@Override 
		public FacilityFeaturesModel.FacilityFeaturesModelBuilder addFeature(List<? extends FacilityFeature> features) {
			if (features != null) {
				for (FacilityFeature toAdd : features) {
					this.feature.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("feature")
		public FacilityFeaturesModel.FacilityFeaturesModelBuilder setFeature(List<? extends FacilityFeature> features) {
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
		@RosettaAttribute("lien")
		public FacilityFeaturesModel.FacilityFeaturesModelBuilder setLien(Lien lien) {
			this.lien = lien==null?null:lien.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("seniority")
		public FacilityFeaturesModel.FacilityFeaturesModelBuilder setSeniority(CreditSeniority seniority) {
			this.seniority = seniority==null?null:seniority.toBuilder();
			return this;
		}
		
		@Override
		public FacilityFeaturesModel build() {
			return new FacilityFeaturesModel.FacilityFeaturesModelImpl(this);
		}
		
		@Override
		public FacilityFeaturesModel.FacilityFeaturesModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FacilityFeaturesModel.FacilityFeaturesModelBuilder prune() {
			feature = feature.stream().filter(b->b!=null).<FacilityFeature.FacilityFeatureBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (lien!=null && !lien.prune().hasData()) lien = null;
			if (seniority!=null && !seniority.prune().hasData()) seniority = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFeature()!=null && getFeature().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getLien()!=null && getLien().hasData()) return true;
			if (getSeniority()!=null && getSeniority().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FacilityFeaturesModel.FacilityFeaturesModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FacilityFeaturesModel.FacilityFeaturesModelBuilder o = (FacilityFeaturesModel.FacilityFeaturesModelBuilder) other;
			
			merger.mergeRosetta(getFeature(), o.getFeature(), this::getOrCreateFeature);
			merger.mergeRosetta(getLien(), o.getLien(), this::setLien);
			merger.mergeRosetta(getSeniority(), o.getSeniority(), this::setSeniority);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FacilityFeaturesModel _that = getType().cast(o);
		
			if (!ListEquals.listEquals(feature, _that.getFeature())) return false;
			if (!Objects.equals(lien, _that.getLien())) return false;
			if (!Objects.equals(seniority, _that.getSeniority())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (feature != null ? feature.hashCode() : 0);
			_result = 31 * _result + (lien != null ? lien.hashCode() : 0);
			_result = 31 * _result + (seniority != null ? seniority.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FacilityFeaturesModelBuilder {" +
				"feature=" + this.feature + ", " +
				"lien=" + this.lien + ", " +
				"seniority=" + this.seniority +
			'}';
		}
	}
}
