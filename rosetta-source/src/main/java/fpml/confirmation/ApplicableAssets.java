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
import fpml.confirmation.ApplicableAssets;
import fpml.confirmation.ApplicableAssets.ApplicableAssetsBuilder;
import fpml.confirmation.ApplicableAssets.ApplicableAssetsBuilderImpl;
import fpml.confirmation.ApplicableAssets.ApplicableAssetsImpl;
import fpml.confirmation.DealIdentifier;
import fpml.confirmation.FacilityIdentifier;
import fpml.confirmation.FacilityType;
import fpml.confirmation.meta.ApplicableAssetsMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A structure that defines the assets (or type of assets) that a particular payment profile may be associated with.
 * @version ${project.version}
 */
@RosettaDataType(value="ApplicableAssets", builder=ApplicableAssets.ApplicableAssetsBuilderImpl.class, version="${project.version}")
public interface ApplicableAssets extends RosettaModelObject {

	ApplicableAssetsMeta metaData = new ApplicableAssetsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The deals for which this default settlement instruction is valid.
	 */
	List<? extends DealIdentifier> getDealIdentifier();
	/**
	 * The facilities for which this default settlement instruction is valid.
	 */
	List<? extends FacilityIdentifier> getFacilityIdentifier();
	/**
	 * The facility type (i.e. term, delayed draw, TLB, etc.) for which this default settlement instruction is valid.
	 */
	List<? extends FacilityType> getFacilityType();

	/*********************** Build Methods  ***********************/
	ApplicableAssets build();
	
	ApplicableAssets.ApplicableAssetsBuilder toBuilder();
	
	static ApplicableAssets.ApplicableAssetsBuilder builder() {
		return new ApplicableAssets.ApplicableAssetsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ApplicableAssets> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ApplicableAssets> getType() {
		return ApplicableAssets.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("dealIdentifier"), processor, DealIdentifier.class, getDealIdentifier());
		processRosetta(path.newSubPath("facilityIdentifier"), processor, FacilityIdentifier.class, getFacilityIdentifier());
		processRosetta(path.newSubPath("facilityType"), processor, FacilityType.class, getFacilityType());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ApplicableAssetsBuilder extends ApplicableAssets, RosettaModelObjectBuilder {
		DealIdentifier.DealIdentifierBuilder getOrCreateDealIdentifier(int _index);
		List<? extends DealIdentifier.DealIdentifierBuilder> getDealIdentifier();
		FacilityIdentifier.FacilityIdentifierBuilder getOrCreateFacilityIdentifier(int _index);
		List<? extends FacilityIdentifier.FacilityIdentifierBuilder> getFacilityIdentifier();
		FacilityType.FacilityTypeBuilder getOrCreateFacilityType(int _index);
		List<? extends FacilityType.FacilityTypeBuilder> getFacilityType();
		ApplicableAssets.ApplicableAssetsBuilder addDealIdentifier(DealIdentifier dealIdentifier0);
		ApplicableAssets.ApplicableAssetsBuilder addDealIdentifier(DealIdentifier dealIdentifier1, int _idx);
		ApplicableAssets.ApplicableAssetsBuilder addDealIdentifier(List<? extends DealIdentifier> dealIdentifier2);
		ApplicableAssets.ApplicableAssetsBuilder setDealIdentifier(List<? extends DealIdentifier> dealIdentifier3);
		ApplicableAssets.ApplicableAssetsBuilder addFacilityIdentifier(FacilityIdentifier facilityIdentifier0);
		ApplicableAssets.ApplicableAssetsBuilder addFacilityIdentifier(FacilityIdentifier facilityIdentifier1, int _idx);
		ApplicableAssets.ApplicableAssetsBuilder addFacilityIdentifier(List<? extends FacilityIdentifier> facilityIdentifier2);
		ApplicableAssets.ApplicableAssetsBuilder setFacilityIdentifier(List<? extends FacilityIdentifier> facilityIdentifier3);
		ApplicableAssets.ApplicableAssetsBuilder addFacilityType(FacilityType facilityType0);
		ApplicableAssets.ApplicableAssetsBuilder addFacilityType(FacilityType facilityType1, int _idx);
		ApplicableAssets.ApplicableAssetsBuilder addFacilityType(List<? extends FacilityType> facilityType2);
		ApplicableAssets.ApplicableAssetsBuilder setFacilityType(List<? extends FacilityType> facilityType3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("dealIdentifier"), processor, DealIdentifier.DealIdentifierBuilder.class, getDealIdentifier());
			processRosetta(path.newSubPath("facilityIdentifier"), processor, FacilityIdentifier.FacilityIdentifierBuilder.class, getFacilityIdentifier());
			processRosetta(path.newSubPath("facilityType"), processor, FacilityType.FacilityTypeBuilder.class, getFacilityType());
		}
		

		ApplicableAssets.ApplicableAssetsBuilder prune();
	}

	/*********************** Immutable Implementation of ApplicableAssets  ***********************/
	class ApplicableAssetsImpl implements ApplicableAssets {
		private final List<? extends DealIdentifier> dealIdentifier;
		private final List<? extends FacilityIdentifier> facilityIdentifier;
		private final List<? extends FacilityType> facilityType;
		
		protected ApplicableAssetsImpl(ApplicableAssets.ApplicableAssetsBuilder builder) {
			this.dealIdentifier = ofNullable(builder.getDealIdentifier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.facilityIdentifier = ofNullable(builder.getFacilityIdentifier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.facilityType = ofNullable(builder.getFacilityType()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("dealIdentifier")
		public List<? extends DealIdentifier> getDealIdentifier() {
			return dealIdentifier;
		}
		
		@Override
		@RosettaAttribute("facilityIdentifier")
		public List<? extends FacilityIdentifier> getFacilityIdentifier() {
			return facilityIdentifier;
		}
		
		@Override
		@RosettaAttribute("facilityType")
		public List<? extends FacilityType> getFacilityType() {
			return facilityType;
		}
		
		@Override
		public ApplicableAssets build() {
			return this;
		}
		
		@Override
		public ApplicableAssets.ApplicableAssetsBuilder toBuilder() {
			ApplicableAssets.ApplicableAssetsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ApplicableAssets.ApplicableAssetsBuilder builder) {
			ofNullable(getDealIdentifier()).ifPresent(builder::setDealIdentifier);
			ofNullable(getFacilityIdentifier()).ifPresent(builder::setFacilityIdentifier);
			ofNullable(getFacilityType()).ifPresent(builder::setFacilityType);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ApplicableAssets _that = getType().cast(o);
		
			if (!ListEquals.listEquals(dealIdentifier, _that.getDealIdentifier())) return false;
			if (!ListEquals.listEquals(facilityIdentifier, _that.getFacilityIdentifier())) return false;
			if (!ListEquals.listEquals(facilityType, _that.getFacilityType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dealIdentifier != null ? dealIdentifier.hashCode() : 0);
			_result = 31 * _result + (facilityIdentifier != null ? facilityIdentifier.hashCode() : 0);
			_result = 31 * _result + (facilityType != null ? facilityType.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ApplicableAssets {" +
				"dealIdentifier=" + this.dealIdentifier + ", " +
				"facilityIdentifier=" + this.facilityIdentifier + ", " +
				"facilityType=" + this.facilityType +
			'}';
		}
	}

	/*********************** Builder Implementation of ApplicableAssets  ***********************/
	class ApplicableAssetsBuilderImpl implements ApplicableAssets.ApplicableAssetsBuilder {
	
		protected List<DealIdentifier.DealIdentifierBuilder> dealIdentifier = new ArrayList<>();
		protected List<FacilityIdentifier.FacilityIdentifierBuilder> facilityIdentifier = new ArrayList<>();
		protected List<FacilityType.FacilityTypeBuilder> facilityType = new ArrayList<>();
	
		public ApplicableAssetsBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("dealIdentifier")
		public List<? extends DealIdentifier.DealIdentifierBuilder> getDealIdentifier() {
			return dealIdentifier;
		}
		
		@Override
		public DealIdentifier.DealIdentifierBuilder getOrCreateDealIdentifier(int _index) {
		
			if (dealIdentifier==null) {
				this.dealIdentifier = new ArrayList<>();
			}
			DealIdentifier.DealIdentifierBuilder result;
			return getIndex(dealIdentifier, _index, () -> {
						DealIdentifier.DealIdentifierBuilder newDealIdentifier = DealIdentifier.builder();
						return newDealIdentifier;
					});
		}
		
		@Override
		@RosettaAttribute("facilityIdentifier")
		public List<? extends FacilityIdentifier.FacilityIdentifierBuilder> getFacilityIdentifier() {
			return facilityIdentifier;
		}
		
		@Override
		public FacilityIdentifier.FacilityIdentifierBuilder getOrCreateFacilityIdentifier(int _index) {
		
			if (facilityIdentifier==null) {
				this.facilityIdentifier = new ArrayList<>();
			}
			FacilityIdentifier.FacilityIdentifierBuilder result;
			return getIndex(facilityIdentifier, _index, () -> {
						FacilityIdentifier.FacilityIdentifierBuilder newFacilityIdentifier = FacilityIdentifier.builder();
						return newFacilityIdentifier;
					});
		}
		
		@Override
		@RosettaAttribute("facilityType")
		public List<? extends FacilityType.FacilityTypeBuilder> getFacilityType() {
			return facilityType;
		}
		
		@Override
		public FacilityType.FacilityTypeBuilder getOrCreateFacilityType(int _index) {
		
			if (facilityType==null) {
				this.facilityType = new ArrayList<>();
			}
			FacilityType.FacilityTypeBuilder result;
			return getIndex(facilityType, _index, () -> {
						FacilityType.FacilityTypeBuilder newFacilityType = FacilityType.builder();
						return newFacilityType;
					});
		}
		
		@Override
		@RosettaAttribute("dealIdentifier")
		public ApplicableAssets.ApplicableAssetsBuilder addDealIdentifier(DealIdentifier dealIdentifier) {
			if (dealIdentifier!=null) this.dealIdentifier.add(dealIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public ApplicableAssets.ApplicableAssetsBuilder addDealIdentifier(DealIdentifier dealIdentifier, int _idx) {
			getIndex(this.dealIdentifier, _idx, () -> dealIdentifier.toBuilder());
			return this;
		}
		@Override 
		public ApplicableAssets.ApplicableAssetsBuilder addDealIdentifier(List<? extends DealIdentifier> dealIdentifiers) {
			if (dealIdentifiers != null) {
				for (DealIdentifier toAdd : dealIdentifiers) {
					this.dealIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public ApplicableAssets.ApplicableAssetsBuilder setDealIdentifier(List<? extends DealIdentifier> dealIdentifiers) {
			if (dealIdentifiers == null)  {
				this.dealIdentifier = new ArrayList<>();
			}
			else {
				this.dealIdentifier = dealIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("facilityIdentifier")
		public ApplicableAssets.ApplicableAssetsBuilder addFacilityIdentifier(FacilityIdentifier facilityIdentifier) {
			if (facilityIdentifier!=null) this.facilityIdentifier.add(facilityIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public ApplicableAssets.ApplicableAssetsBuilder addFacilityIdentifier(FacilityIdentifier facilityIdentifier, int _idx) {
			getIndex(this.facilityIdentifier, _idx, () -> facilityIdentifier.toBuilder());
			return this;
		}
		@Override 
		public ApplicableAssets.ApplicableAssetsBuilder addFacilityIdentifier(List<? extends FacilityIdentifier> facilityIdentifiers) {
			if (facilityIdentifiers != null) {
				for (FacilityIdentifier toAdd : facilityIdentifiers) {
					this.facilityIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public ApplicableAssets.ApplicableAssetsBuilder setFacilityIdentifier(List<? extends FacilityIdentifier> facilityIdentifiers) {
			if (facilityIdentifiers == null)  {
				this.facilityIdentifier = new ArrayList<>();
			}
			else {
				this.facilityIdentifier = facilityIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("facilityType")
		public ApplicableAssets.ApplicableAssetsBuilder addFacilityType(FacilityType facilityType) {
			if (facilityType!=null) this.facilityType.add(facilityType.toBuilder());
			return this;
		}
		
		@Override
		public ApplicableAssets.ApplicableAssetsBuilder addFacilityType(FacilityType facilityType, int _idx) {
			getIndex(this.facilityType, _idx, () -> facilityType.toBuilder());
			return this;
		}
		@Override 
		public ApplicableAssets.ApplicableAssetsBuilder addFacilityType(List<? extends FacilityType> facilityTypes) {
			if (facilityTypes != null) {
				for (FacilityType toAdd : facilityTypes) {
					this.facilityType.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public ApplicableAssets.ApplicableAssetsBuilder setFacilityType(List<? extends FacilityType> facilityTypes) {
			if (facilityTypes == null)  {
				this.facilityType = new ArrayList<>();
			}
			else {
				this.facilityType = facilityTypes.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public ApplicableAssets build() {
			return new ApplicableAssets.ApplicableAssetsImpl(this);
		}
		
		@Override
		public ApplicableAssets.ApplicableAssetsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ApplicableAssets.ApplicableAssetsBuilder prune() {
			dealIdentifier = dealIdentifier.stream().filter(b->b!=null).<DealIdentifier.DealIdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			facilityIdentifier = facilityIdentifier.stream().filter(b->b!=null).<FacilityIdentifier.FacilityIdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			facilityType = facilityType.stream().filter(b->b!=null).<FacilityType.FacilityTypeBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDealIdentifier()!=null && getDealIdentifier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getFacilityIdentifier()!=null && getFacilityIdentifier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getFacilityType()!=null && getFacilityType().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ApplicableAssets.ApplicableAssetsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ApplicableAssets.ApplicableAssetsBuilder o = (ApplicableAssets.ApplicableAssetsBuilder) other;
			
			merger.mergeRosetta(getDealIdentifier(), o.getDealIdentifier(), this::getOrCreateDealIdentifier);
			merger.mergeRosetta(getFacilityIdentifier(), o.getFacilityIdentifier(), this::getOrCreateFacilityIdentifier);
			merger.mergeRosetta(getFacilityType(), o.getFacilityType(), this::getOrCreateFacilityType);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ApplicableAssets _that = getType().cast(o);
		
			if (!ListEquals.listEquals(dealIdentifier, _that.getDealIdentifier())) return false;
			if (!ListEquals.listEquals(facilityIdentifier, _that.getFacilityIdentifier())) return false;
			if (!ListEquals.listEquals(facilityType, _that.getFacilityType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dealIdentifier != null ? dealIdentifier.hashCode() : 0);
			_result = 31 * _result + (facilityIdentifier != null ? facilityIdentifier.hashCode() : 0);
			_result = 31 * _result + (facilityType != null ? facilityType.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ApplicableAssetsBuilder {" +
				"dealIdentifier=" + this.dealIdentifier + ", " +
				"facilityIdentifier=" + this.facilityIdentifier + ", " +
				"facilityType=" + this.facilityType +
			'}';
		}
	}
}
