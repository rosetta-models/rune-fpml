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
import fpml.confirmation.CountryCode;
import fpml.confirmation.CreditRating;
import fpml.confirmation.GoverningLaw;
import fpml.confirmation.IndustryClassification;
import fpml.confirmation.OrganizationType;
import fpml.confirmation.PartyInformationModel;
import fpml.confirmation.PartyInformationModel.PartyInformationModelBuilder;
import fpml.confirmation.PartyInformationModel.PartyInformationModelBuilderImpl;
import fpml.confirmation.PartyInformationModel.PartyInformationModelImpl;
import fpml.confirmation.Region;
import fpml.confirmation.meta.PartyInformationModelMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Information about a party for reporting purposes.
 * @version ${project.version}
 */
@RosettaDataType(value="PartyInformationModel", builder=PartyInformationModel.PartyInformationModelBuilderImpl.class, version="${project.version}")
public interface PartyInformationModel extends RosettaModelObject {

	PartyInformationModelMeta metaData = new PartyInformationModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The party&#39;s industry sector classification.
	 */
	List<? extends IndustryClassification> getClassification();
	/**
	 * The party&#39;s credit rating.
	 */
	List<? extends CreditRating> getCreditRating();
	/**
	 * The country where the party is domiciled.
	 */
	CountryCode getCountry();
	/**
	 * A code for a grouping of countries to which this belongs.
	 */
	List<? extends Region> getRegion();
	/**
	 * The legal jurisdiction of the entity&#39;s registration.
	 */
	List<? extends GoverningLaw> getJurisdiction();
	/**
	 * The type of an organization&#39;s participantion in the OTC derivatives market.
	 */
	OrganizationType getOrganizationType();

	/*********************** Build Methods  ***********************/
	PartyInformationModel build();
	
	PartyInformationModel.PartyInformationModelBuilder toBuilder();
	
	static PartyInformationModel.PartyInformationModelBuilder builder() {
		return new PartyInformationModel.PartyInformationModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PartyInformationModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PartyInformationModel> getType() {
		return PartyInformationModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("classification"), processor, IndustryClassification.class, getClassification());
		processRosetta(path.newSubPath("creditRating"), processor, CreditRating.class, getCreditRating());
		processRosetta(path.newSubPath("country"), processor, CountryCode.class, getCountry());
		processRosetta(path.newSubPath("region"), processor, Region.class, getRegion());
		processRosetta(path.newSubPath("jurisdiction"), processor, GoverningLaw.class, getJurisdiction());
		processRosetta(path.newSubPath("organizationType"), processor, OrganizationType.class, getOrganizationType());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PartyInformationModelBuilder extends PartyInformationModel, RosettaModelObjectBuilder {
		IndustryClassification.IndustryClassificationBuilder getOrCreateClassification(int _index);
		List<? extends IndustryClassification.IndustryClassificationBuilder> getClassification();
		CreditRating.CreditRatingBuilder getOrCreateCreditRating(int _index);
		List<? extends CreditRating.CreditRatingBuilder> getCreditRating();
		CountryCode.CountryCodeBuilder getOrCreateCountry();
		CountryCode.CountryCodeBuilder getCountry();
		Region.RegionBuilder getOrCreateRegion(int _index);
		List<? extends Region.RegionBuilder> getRegion();
		GoverningLaw.GoverningLawBuilder getOrCreateJurisdiction(int _index);
		List<? extends GoverningLaw.GoverningLawBuilder> getJurisdiction();
		OrganizationType.OrganizationTypeBuilder getOrCreateOrganizationType();
		OrganizationType.OrganizationTypeBuilder getOrganizationType();
		PartyInformationModel.PartyInformationModelBuilder addClassification(IndustryClassification classification0);
		PartyInformationModel.PartyInformationModelBuilder addClassification(IndustryClassification classification1, int _idx);
		PartyInformationModel.PartyInformationModelBuilder addClassification(List<? extends IndustryClassification> classification2);
		PartyInformationModel.PartyInformationModelBuilder setClassification(List<? extends IndustryClassification> classification3);
		PartyInformationModel.PartyInformationModelBuilder addCreditRating(CreditRating creditRating0);
		PartyInformationModel.PartyInformationModelBuilder addCreditRating(CreditRating creditRating1, int _idx);
		PartyInformationModel.PartyInformationModelBuilder addCreditRating(List<? extends CreditRating> creditRating2);
		PartyInformationModel.PartyInformationModelBuilder setCreditRating(List<? extends CreditRating> creditRating3);
		PartyInformationModel.PartyInformationModelBuilder setCountry(CountryCode country);
		PartyInformationModel.PartyInformationModelBuilder addRegion(Region region0);
		PartyInformationModel.PartyInformationModelBuilder addRegion(Region region1, int _idx);
		PartyInformationModel.PartyInformationModelBuilder addRegion(List<? extends Region> region2);
		PartyInformationModel.PartyInformationModelBuilder setRegion(List<? extends Region> region3);
		PartyInformationModel.PartyInformationModelBuilder addJurisdiction(GoverningLaw jurisdiction0);
		PartyInformationModel.PartyInformationModelBuilder addJurisdiction(GoverningLaw jurisdiction1, int _idx);
		PartyInformationModel.PartyInformationModelBuilder addJurisdiction(List<? extends GoverningLaw> jurisdiction2);
		PartyInformationModel.PartyInformationModelBuilder setJurisdiction(List<? extends GoverningLaw> jurisdiction3);
		PartyInformationModel.PartyInformationModelBuilder setOrganizationType(OrganizationType organizationType);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("classification"), processor, IndustryClassification.IndustryClassificationBuilder.class, getClassification());
			processRosetta(path.newSubPath("creditRating"), processor, CreditRating.CreditRatingBuilder.class, getCreditRating());
			processRosetta(path.newSubPath("country"), processor, CountryCode.CountryCodeBuilder.class, getCountry());
			processRosetta(path.newSubPath("region"), processor, Region.RegionBuilder.class, getRegion());
			processRosetta(path.newSubPath("jurisdiction"), processor, GoverningLaw.GoverningLawBuilder.class, getJurisdiction());
			processRosetta(path.newSubPath("organizationType"), processor, OrganizationType.OrganizationTypeBuilder.class, getOrganizationType());
		}
		

		PartyInformationModel.PartyInformationModelBuilder prune();
	}

	/*********************** Immutable Implementation of PartyInformationModel  ***********************/
	class PartyInformationModelImpl implements PartyInformationModel {
		private final List<? extends IndustryClassification> classification;
		private final List<? extends CreditRating> creditRating;
		private final CountryCode country;
		private final List<? extends Region> region;
		private final List<? extends GoverningLaw> jurisdiction;
		private final OrganizationType organizationType;
		
		protected PartyInformationModelImpl(PartyInformationModel.PartyInformationModelBuilder builder) {
			this.classification = ofNullable(builder.getClassification()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.creditRating = ofNullable(builder.getCreditRating()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.country = ofNullable(builder.getCountry()).map(f->f.build()).orElse(null);
			this.region = ofNullable(builder.getRegion()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.jurisdiction = ofNullable(builder.getJurisdiction()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.organizationType = ofNullable(builder.getOrganizationType()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("classification")
		public List<? extends IndustryClassification> getClassification() {
			return classification;
		}
		
		@Override
		@RosettaAttribute("creditRating")
		public List<? extends CreditRating> getCreditRating() {
			return creditRating;
		}
		
		@Override
		@RosettaAttribute("country")
		public CountryCode getCountry() {
			return country;
		}
		
		@Override
		@RosettaAttribute("region")
		public List<? extends Region> getRegion() {
			return region;
		}
		
		@Override
		@RosettaAttribute("jurisdiction")
		public List<? extends GoverningLaw> getJurisdiction() {
			return jurisdiction;
		}
		
		@Override
		@RosettaAttribute("organizationType")
		public OrganizationType getOrganizationType() {
			return organizationType;
		}
		
		@Override
		public PartyInformationModel build() {
			return this;
		}
		
		@Override
		public PartyInformationModel.PartyInformationModelBuilder toBuilder() {
			PartyInformationModel.PartyInformationModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PartyInformationModel.PartyInformationModelBuilder builder) {
			ofNullable(getClassification()).ifPresent(builder::setClassification);
			ofNullable(getCreditRating()).ifPresent(builder::setCreditRating);
			ofNullable(getCountry()).ifPresent(builder::setCountry);
			ofNullable(getRegion()).ifPresent(builder::setRegion);
			ofNullable(getJurisdiction()).ifPresent(builder::setJurisdiction);
			ofNullable(getOrganizationType()).ifPresent(builder::setOrganizationType);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyInformationModel _that = getType().cast(o);
		
			if (!ListEquals.listEquals(classification, _that.getClassification())) return false;
			if (!ListEquals.listEquals(creditRating, _that.getCreditRating())) return false;
			if (!Objects.equals(country, _that.getCountry())) return false;
			if (!ListEquals.listEquals(region, _that.getRegion())) return false;
			if (!ListEquals.listEquals(jurisdiction, _that.getJurisdiction())) return false;
			if (!Objects.equals(organizationType, _that.getOrganizationType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (classification != null ? classification.hashCode() : 0);
			_result = 31 * _result + (creditRating != null ? creditRating.hashCode() : 0);
			_result = 31 * _result + (country != null ? country.hashCode() : 0);
			_result = 31 * _result + (region != null ? region.hashCode() : 0);
			_result = 31 * _result + (jurisdiction != null ? jurisdiction.hashCode() : 0);
			_result = 31 * _result + (organizationType != null ? organizationType.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyInformationModel {" +
				"classification=" + this.classification + ", " +
				"creditRating=" + this.creditRating + ", " +
				"country=" + this.country + ", " +
				"region=" + this.region + ", " +
				"jurisdiction=" + this.jurisdiction + ", " +
				"organizationType=" + this.organizationType +
			'}';
		}
	}

	/*********************** Builder Implementation of PartyInformationModel  ***********************/
	class PartyInformationModelBuilderImpl implements PartyInformationModel.PartyInformationModelBuilder {
	
		protected List<IndustryClassification.IndustryClassificationBuilder> classification = new ArrayList<>();
		protected List<CreditRating.CreditRatingBuilder> creditRating = new ArrayList<>();
		protected CountryCode.CountryCodeBuilder country;
		protected List<Region.RegionBuilder> region = new ArrayList<>();
		protected List<GoverningLaw.GoverningLawBuilder> jurisdiction = new ArrayList<>();
		protected OrganizationType.OrganizationTypeBuilder organizationType;
	
		public PartyInformationModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("classification")
		public List<? extends IndustryClassification.IndustryClassificationBuilder> getClassification() {
			return classification;
		}
		
		public IndustryClassification.IndustryClassificationBuilder getOrCreateClassification(int _index) {
		
			if (classification==null) {
				this.classification = new ArrayList<>();
			}
			IndustryClassification.IndustryClassificationBuilder result;
			return getIndex(classification, _index, () -> {
						IndustryClassification.IndustryClassificationBuilder newClassification = IndustryClassification.builder();
						return newClassification;
					});
		}
		
		@Override
		@RosettaAttribute("creditRating")
		public List<? extends CreditRating.CreditRatingBuilder> getCreditRating() {
			return creditRating;
		}
		
		public CreditRating.CreditRatingBuilder getOrCreateCreditRating(int _index) {
		
			if (creditRating==null) {
				this.creditRating = new ArrayList<>();
			}
			CreditRating.CreditRatingBuilder result;
			return getIndex(creditRating, _index, () -> {
						CreditRating.CreditRatingBuilder newCreditRating = CreditRating.builder();
						return newCreditRating;
					});
		}
		
		@Override
		@RosettaAttribute("country")
		public CountryCode.CountryCodeBuilder getCountry() {
			return country;
		}
		
		@Override
		public CountryCode.CountryCodeBuilder getOrCreateCountry() {
			CountryCode.CountryCodeBuilder result;
			if (country!=null) {
				result = country;
			}
			else {
				result = country = CountryCode.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("region")
		public List<? extends Region.RegionBuilder> getRegion() {
			return region;
		}
		
		public Region.RegionBuilder getOrCreateRegion(int _index) {
		
			if (region==null) {
				this.region = new ArrayList<>();
			}
			Region.RegionBuilder result;
			return getIndex(region, _index, () -> {
						Region.RegionBuilder newRegion = Region.builder();
						return newRegion;
					});
		}
		
		@Override
		@RosettaAttribute("jurisdiction")
		public List<? extends GoverningLaw.GoverningLawBuilder> getJurisdiction() {
			return jurisdiction;
		}
		
		public GoverningLaw.GoverningLawBuilder getOrCreateJurisdiction(int _index) {
		
			if (jurisdiction==null) {
				this.jurisdiction = new ArrayList<>();
			}
			GoverningLaw.GoverningLawBuilder result;
			return getIndex(jurisdiction, _index, () -> {
						GoverningLaw.GoverningLawBuilder newJurisdiction = GoverningLaw.builder();
						return newJurisdiction;
					});
		}
		
		@Override
		@RosettaAttribute("organizationType")
		public OrganizationType.OrganizationTypeBuilder getOrganizationType() {
			return organizationType;
		}
		
		@Override
		public OrganizationType.OrganizationTypeBuilder getOrCreateOrganizationType() {
			OrganizationType.OrganizationTypeBuilder result;
			if (organizationType!=null) {
				result = organizationType;
			}
			else {
				result = organizationType = OrganizationType.builder();
			}
			
			return result;
		}
		
		@Override
		public PartyInformationModel.PartyInformationModelBuilder addClassification(IndustryClassification classification) {
			if (classification!=null) this.classification.add(classification.toBuilder());
			return this;
		}
		
		@Override
		public PartyInformationModel.PartyInformationModelBuilder addClassification(IndustryClassification classification, int _idx) {
			getIndex(this.classification, _idx, () -> classification.toBuilder());
			return this;
		}
		@Override 
		public PartyInformationModel.PartyInformationModelBuilder addClassification(List<? extends IndustryClassification> classifications) {
			if (classifications != null) {
				for (IndustryClassification toAdd : classifications) {
					this.classification.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("classification")
		public PartyInformationModel.PartyInformationModelBuilder setClassification(List<? extends IndustryClassification> classifications) {
			if (classifications == null)  {
				this.classification = new ArrayList<>();
			}
			else {
				this.classification = classifications.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public PartyInformationModel.PartyInformationModelBuilder addCreditRating(CreditRating creditRating) {
			if (creditRating!=null) this.creditRating.add(creditRating.toBuilder());
			return this;
		}
		
		@Override
		public PartyInformationModel.PartyInformationModelBuilder addCreditRating(CreditRating creditRating, int _idx) {
			getIndex(this.creditRating, _idx, () -> creditRating.toBuilder());
			return this;
		}
		@Override 
		public PartyInformationModel.PartyInformationModelBuilder addCreditRating(List<? extends CreditRating> creditRatings) {
			if (creditRatings != null) {
				for (CreditRating toAdd : creditRatings) {
					this.creditRating.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("creditRating")
		public PartyInformationModel.PartyInformationModelBuilder setCreditRating(List<? extends CreditRating> creditRatings) {
			if (creditRatings == null)  {
				this.creditRating = new ArrayList<>();
			}
			else {
				this.creditRating = creditRatings.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("country")
		public PartyInformationModel.PartyInformationModelBuilder setCountry(CountryCode country) {
			this.country = country==null?null:country.toBuilder();
			return this;
		}
		@Override
		public PartyInformationModel.PartyInformationModelBuilder addRegion(Region region) {
			if (region!=null) this.region.add(region.toBuilder());
			return this;
		}
		
		@Override
		public PartyInformationModel.PartyInformationModelBuilder addRegion(Region region, int _idx) {
			getIndex(this.region, _idx, () -> region.toBuilder());
			return this;
		}
		@Override 
		public PartyInformationModel.PartyInformationModelBuilder addRegion(List<? extends Region> regions) {
			if (regions != null) {
				for (Region toAdd : regions) {
					this.region.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("region")
		public PartyInformationModel.PartyInformationModelBuilder setRegion(List<? extends Region> regions) {
			if (regions == null)  {
				this.region = new ArrayList<>();
			}
			else {
				this.region = regions.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public PartyInformationModel.PartyInformationModelBuilder addJurisdiction(GoverningLaw jurisdiction) {
			if (jurisdiction!=null) this.jurisdiction.add(jurisdiction.toBuilder());
			return this;
		}
		
		@Override
		public PartyInformationModel.PartyInformationModelBuilder addJurisdiction(GoverningLaw jurisdiction, int _idx) {
			getIndex(this.jurisdiction, _idx, () -> jurisdiction.toBuilder());
			return this;
		}
		@Override 
		public PartyInformationModel.PartyInformationModelBuilder addJurisdiction(List<? extends GoverningLaw> jurisdictions) {
			if (jurisdictions != null) {
				for (GoverningLaw toAdd : jurisdictions) {
					this.jurisdiction.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("jurisdiction")
		public PartyInformationModel.PartyInformationModelBuilder setJurisdiction(List<? extends GoverningLaw> jurisdictions) {
			if (jurisdictions == null)  {
				this.jurisdiction = new ArrayList<>();
			}
			else {
				this.jurisdiction = jurisdictions.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("organizationType")
		public PartyInformationModel.PartyInformationModelBuilder setOrganizationType(OrganizationType organizationType) {
			this.organizationType = organizationType==null?null:organizationType.toBuilder();
			return this;
		}
		
		@Override
		public PartyInformationModel build() {
			return new PartyInformationModel.PartyInformationModelImpl(this);
		}
		
		@Override
		public PartyInformationModel.PartyInformationModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyInformationModel.PartyInformationModelBuilder prune() {
			classification = classification.stream().filter(b->b!=null).<IndustryClassification.IndustryClassificationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			creditRating = creditRating.stream().filter(b->b!=null).<CreditRating.CreditRatingBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (country!=null && !country.prune().hasData()) country = null;
			region = region.stream().filter(b->b!=null).<Region.RegionBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			jurisdiction = jurisdiction.stream().filter(b->b!=null).<GoverningLaw.GoverningLawBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (organizationType!=null && !organizationType.prune().hasData()) organizationType = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getClassification()!=null && getClassification().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCreditRating()!=null && getCreditRating().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCountry()!=null && getCountry().hasData()) return true;
			if (getRegion()!=null && getRegion().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getJurisdiction()!=null && getJurisdiction().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getOrganizationType()!=null && getOrganizationType().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyInformationModel.PartyInformationModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PartyInformationModel.PartyInformationModelBuilder o = (PartyInformationModel.PartyInformationModelBuilder) other;
			
			merger.mergeRosetta(getClassification(), o.getClassification(), this::getOrCreateClassification);
			merger.mergeRosetta(getCreditRating(), o.getCreditRating(), this::getOrCreateCreditRating);
			merger.mergeRosetta(getCountry(), o.getCountry(), this::setCountry);
			merger.mergeRosetta(getRegion(), o.getRegion(), this::getOrCreateRegion);
			merger.mergeRosetta(getJurisdiction(), o.getJurisdiction(), this::getOrCreateJurisdiction);
			merger.mergeRosetta(getOrganizationType(), o.getOrganizationType(), this::setOrganizationType);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyInformationModel _that = getType().cast(o);
		
			if (!ListEquals.listEquals(classification, _that.getClassification())) return false;
			if (!ListEquals.listEquals(creditRating, _that.getCreditRating())) return false;
			if (!Objects.equals(country, _that.getCountry())) return false;
			if (!ListEquals.listEquals(region, _that.getRegion())) return false;
			if (!ListEquals.listEquals(jurisdiction, _that.getJurisdiction())) return false;
			if (!Objects.equals(organizationType, _that.getOrganizationType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (classification != null ? classification.hashCode() : 0);
			_result = 31 * _result + (creditRating != null ? creditRating.hashCode() : 0);
			_result = 31 * _result + (country != null ? country.hashCode() : 0);
			_result = 31 * _result + (region != null ? region.hashCode() : 0);
			_result = 31 * _result + (jurisdiction != null ? jurisdiction.hashCode() : 0);
			_result = 31 * _result + (organizationType != null ? organizationType.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyInformationModelBuilder {" +
				"classification=" + this.classification + ", " +
				"creditRating=" + this.creditRating + ", " +
				"country=" + this.country + ", " +
				"region=" + this.region + ", " +
				"jurisdiction=" + this.jurisdiction + ", " +
				"organizationType=" + this.organizationType +
			'}';
		}
	}
}
