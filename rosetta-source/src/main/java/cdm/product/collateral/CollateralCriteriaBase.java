package cdm.product.collateral;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.product.collateral.AssetCriteria;
import cdm.product.collateral.CollateralCriteriaBase;
import cdm.product.collateral.CollateralCriteriaBase.CollateralCriteriaBaseBuilder;
import cdm.product.collateral.CollateralCriteriaBase.CollateralCriteriaBaseBuilderImpl;
import cdm.product.collateral.CollateralCriteriaBase.CollateralCriteriaBaseImpl;
import cdm.product.collateral.CollateralMarginTypeEnum;
import cdm.product.collateral.IssuerCriteria;
import cdm.product.collateral.RatingPriorityResolutionEnum;
import cdm.product.collateral.meta.CollateralCriteriaBaseMeta;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Represents a set of criteria used to specify and describe collateral.
 * @version 6.0.0-dev.76
 */
@RosettaDataType(value="CollateralCriteriaBase", builder=CollateralCriteriaBase.CollateralCriteriaBaseBuilderImpl.class, version="6.0.0-dev.76")
public interface CollateralCriteriaBase extends RosettaModelObject {

	CollateralCriteriaBaseMeta metaData = new CollateralCriteriaBaseMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Represents a filter based criteria related to the issuer.
	 */
	List<? extends IssuerCriteria> getIssuer();
	/**
	 * Represents a filter based on the criteria related to the asset.
	 */
	List<? extends AssetCriteria> getAsset();
	/**
	 * Specifies which of the two counterparties the criteria applies to (either one or both counterparties). This attribute is optional, in case the applicable party is already specified elsewhere within a party election.
	 */
	List<CounterpartyRoleEnum> getAppliesTo();
	/**
	 * Restrict the criteria to only apply to a specific type of margin, ie IM or VM.
	 */
	CollateralMarginTypeEnum getRestrictTo();
	/**
	 * Denotes which Criteria has priority if more than one agency rating applies.
	 */
	RatingPriorityResolutionEnum getRatingPriorityResolution();

	/*********************** Build Methods  ***********************/
	CollateralCriteriaBase build();
	
	CollateralCriteriaBase.CollateralCriteriaBaseBuilder toBuilder();
	
	static CollateralCriteriaBase.CollateralCriteriaBaseBuilder builder() {
		return new CollateralCriteriaBase.CollateralCriteriaBaseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CollateralCriteriaBase> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CollateralCriteriaBase> getType() {
		return CollateralCriteriaBase.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("issuer"), processor, IssuerCriteria.class, getIssuer());
		processRosetta(path.newSubPath("asset"), processor, AssetCriteria.class, getAsset());
		processor.processBasic(path.newSubPath("appliesTo"), CounterpartyRoleEnum.class, getAppliesTo(), this);
		processor.processBasic(path.newSubPath("restrictTo"), CollateralMarginTypeEnum.class, getRestrictTo(), this);
		processor.processBasic(path.newSubPath("ratingPriorityResolution"), RatingPriorityResolutionEnum.class, getRatingPriorityResolution(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CollateralCriteriaBaseBuilder extends CollateralCriteriaBase, RosettaModelObjectBuilder {
		IssuerCriteria.IssuerCriteriaBuilder getOrCreateIssuer(int _index);
		List<? extends IssuerCriteria.IssuerCriteriaBuilder> getIssuer();
		AssetCriteria.AssetCriteriaBuilder getOrCreateAsset(int _index);
		List<? extends AssetCriteria.AssetCriteriaBuilder> getAsset();
		CollateralCriteriaBase.CollateralCriteriaBaseBuilder addIssuer(IssuerCriteria issuer0);
		CollateralCriteriaBase.CollateralCriteriaBaseBuilder addIssuer(IssuerCriteria issuer1, int _idx);
		CollateralCriteriaBase.CollateralCriteriaBaseBuilder addIssuer(List<? extends IssuerCriteria> issuer2);
		CollateralCriteriaBase.CollateralCriteriaBaseBuilder setIssuer(List<? extends IssuerCriteria> issuer3);
		CollateralCriteriaBase.CollateralCriteriaBaseBuilder addAsset(AssetCriteria asset0);
		CollateralCriteriaBase.CollateralCriteriaBaseBuilder addAsset(AssetCriteria asset1, int _idx);
		CollateralCriteriaBase.CollateralCriteriaBaseBuilder addAsset(List<? extends AssetCriteria> asset2);
		CollateralCriteriaBase.CollateralCriteriaBaseBuilder setAsset(List<? extends AssetCriteria> asset3);
		CollateralCriteriaBase.CollateralCriteriaBaseBuilder addAppliesTo(CounterpartyRoleEnum appliesTo0);
		CollateralCriteriaBase.CollateralCriteriaBaseBuilder addAppliesTo(CounterpartyRoleEnum appliesTo1, int _idx);
		CollateralCriteriaBase.CollateralCriteriaBaseBuilder addAppliesTo(List<CounterpartyRoleEnum> appliesTo2);
		CollateralCriteriaBase.CollateralCriteriaBaseBuilder setAppliesTo(List<CounterpartyRoleEnum> appliesTo3);
		CollateralCriteriaBase.CollateralCriteriaBaseBuilder setRestrictTo(CollateralMarginTypeEnum restrictTo);
		CollateralCriteriaBase.CollateralCriteriaBaseBuilder setRatingPriorityResolution(RatingPriorityResolutionEnum ratingPriorityResolution);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("issuer"), processor, IssuerCriteria.IssuerCriteriaBuilder.class, getIssuer());
			processRosetta(path.newSubPath("asset"), processor, AssetCriteria.AssetCriteriaBuilder.class, getAsset());
			processor.processBasic(path.newSubPath("appliesTo"), CounterpartyRoleEnum.class, getAppliesTo(), this);
			processor.processBasic(path.newSubPath("restrictTo"), CollateralMarginTypeEnum.class, getRestrictTo(), this);
			processor.processBasic(path.newSubPath("ratingPriorityResolution"), RatingPriorityResolutionEnum.class, getRatingPriorityResolution(), this);
		}
		

		CollateralCriteriaBase.CollateralCriteriaBaseBuilder prune();
	}

	/*********************** Immutable Implementation of CollateralCriteriaBase  ***********************/
	class CollateralCriteriaBaseImpl implements CollateralCriteriaBase {
		private final List<? extends IssuerCriteria> issuer;
		private final List<? extends AssetCriteria> asset;
		private final List<CounterpartyRoleEnum> appliesTo;
		private final CollateralMarginTypeEnum restrictTo;
		private final RatingPriorityResolutionEnum ratingPriorityResolution;
		
		protected CollateralCriteriaBaseImpl(CollateralCriteriaBase.CollateralCriteriaBaseBuilder builder) {
			this.issuer = ofNullable(builder.getIssuer()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.asset = ofNullable(builder.getAsset()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.appliesTo = ofNullable(builder.getAppliesTo()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.restrictTo = builder.getRestrictTo();
			this.ratingPriorityResolution = builder.getRatingPriorityResolution();
		}
		
		@Override
		@RosettaAttribute("issuer")
		public List<? extends IssuerCriteria> getIssuer() {
			return issuer;
		}
		
		@Override
		@RosettaAttribute("asset")
		public List<? extends AssetCriteria> getAsset() {
			return asset;
		}
		
		@Override
		@RosettaAttribute("appliesTo")
		public List<CounterpartyRoleEnum> getAppliesTo() {
			return appliesTo;
		}
		
		@Override
		@RosettaAttribute("restrictTo")
		public CollateralMarginTypeEnum getRestrictTo() {
			return restrictTo;
		}
		
		@Override
		@RosettaAttribute("ratingPriorityResolution")
		public RatingPriorityResolutionEnum getRatingPriorityResolution() {
			return ratingPriorityResolution;
		}
		
		@Override
		public CollateralCriteriaBase build() {
			return this;
		}
		
		@Override
		public CollateralCriteriaBase.CollateralCriteriaBaseBuilder toBuilder() {
			CollateralCriteriaBase.CollateralCriteriaBaseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CollateralCriteriaBase.CollateralCriteriaBaseBuilder builder) {
			ofNullable(getIssuer()).ifPresent(builder::setIssuer);
			ofNullable(getAsset()).ifPresent(builder::setAsset);
			ofNullable(getAppliesTo()).ifPresent(builder::setAppliesTo);
			ofNullable(getRestrictTo()).ifPresent(builder::setRestrictTo);
			ofNullable(getRatingPriorityResolution()).ifPresent(builder::setRatingPriorityResolution);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CollateralCriteriaBase _that = getType().cast(o);
		
			if (!ListEquals.listEquals(issuer, _that.getIssuer())) return false;
			if (!ListEquals.listEquals(asset, _that.getAsset())) return false;
			if (!ListEquals.listEquals(appliesTo, _that.getAppliesTo())) return false;
			if (!Objects.equals(restrictTo, _that.getRestrictTo())) return false;
			if (!Objects.equals(ratingPriorityResolution, _that.getRatingPriorityResolution())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (issuer != null ? issuer.hashCode() : 0);
			_result = 31 * _result + (asset != null ? asset.hashCode() : 0);
			_result = 31 * _result + (appliesTo != null ? appliesTo.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			_result = 31 * _result + (restrictTo != null ? restrictTo.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (ratingPriorityResolution != null ? ratingPriorityResolution.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CollateralCriteriaBase {" +
				"issuer=" + this.issuer + ", " +
				"asset=" + this.asset + ", " +
				"appliesTo=" + this.appliesTo + ", " +
				"restrictTo=" + this.restrictTo + ", " +
				"ratingPriorityResolution=" + this.ratingPriorityResolution +
			'}';
		}
	}

	/*********************** Builder Implementation of CollateralCriteriaBase  ***********************/
	class CollateralCriteriaBaseBuilderImpl implements CollateralCriteriaBase.CollateralCriteriaBaseBuilder {
	
		protected List<IssuerCriteria.IssuerCriteriaBuilder> issuer = new ArrayList<>();
		protected List<AssetCriteria.AssetCriteriaBuilder> asset = new ArrayList<>();
		protected List<CounterpartyRoleEnum> appliesTo = new ArrayList<>();
		protected CollateralMarginTypeEnum restrictTo;
		protected RatingPriorityResolutionEnum ratingPriorityResolution;
	
		public CollateralCriteriaBaseBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("issuer")
		public List<? extends IssuerCriteria.IssuerCriteriaBuilder> getIssuer() {
			return issuer;
		}
		
		@Override
		public IssuerCriteria.IssuerCriteriaBuilder getOrCreateIssuer(int _index) {
		
			if (issuer==null) {
				this.issuer = new ArrayList<>();
			}
			IssuerCriteria.IssuerCriteriaBuilder result;
			return getIndex(issuer, _index, () -> {
						IssuerCriteria.IssuerCriteriaBuilder newIssuer = IssuerCriteria.builder();
						return newIssuer;
					});
		}
		
		@Override
		@RosettaAttribute("asset")
		public List<? extends AssetCriteria.AssetCriteriaBuilder> getAsset() {
			return asset;
		}
		
		@Override
		public AssetCriteria.AssetCriteriaBuilder getOrCreateAsset(int _index) {
		
			if (asset==null) {
				this.asset = new ArrayList<>();
			}
			AssetCriteria.AssetCriteriaBuilder result;
			return getIndex(asset, _index, () -> {
						AssetCriteria.AssetCriteriaBuilder newAsset = AssetCriteria.builder();
						return newAsset;
					});
		}
		
		@Override
		@RosettaAttribute("appliesTo")
		public List<CounterpartyRoleEnum> getAppliesTo() {
			return appliesTo;
		}
		
		@Override
		@RosettaAttribute("restrictTo")
		public CollateralMarginTypeEnum getRestrictTo() {
			return restrictTo;
		}
		
		@Override
		@RosettaAttribute("ratingPriorityResolution")
		public RatingPriorityResolutionEnum getRatingPriorityResolution() {
			return ratingPriorityResolution;
		}
		
		@Override
		@RosettaAttribute("issuer")
		public CollateralCriteriaBase.CollateralCriteriaBaseBuilder addIssuer(IssuerCriteria issuer) {
			if (issuer!=null) this.issuer.add(issuer.toBuilder());
			return this;
		}
		
		@Override
		public CollateralCriteriaBase.CollateralCriteriaBaseBuilder addIssuer(IssuerCriteria issuer, int _idx) {
			getIndex(this.issuer, _idx, () -> issuer.toBuilder());
			return this;
		}
		@Override 
		public CollateralCriteriaBase.CollateralCriteriaBaseBuilder addIssuer(List<? extends IssuerCriteria> issuers) {
			if (issuers != null) {
				for (IssuerCriteria toAdd : issuers) {
					this.issuer.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public CollateralCriteriaBase.CollateralCriteriaBaseBuilder setIssuer(List<? extends IssuerCriteria> issuers) {
			if (issuers == null)  {
				this.issuer = new ArrayList<>();
			}
			else {
				this.issuer = issuers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("asset")
		public CollateralCriteriaBase.CollateralCriteriaBaseBuilder addAsset(AssetCriteria asset) {
			if (asset!=null) this.asset.add(asset.toBuilder());
			return this;
		}
		
		@Override
		public CollateralCriteriaBase.CollateralCriteriaBaseBuilder addAsset(AssetCriteria asset, int _idx) {
			getIndex(this.asset, _idx, () -> asset.toBuilder());
			return this;
		}
		@Override 
		public CollateralCriteriaBase.CollateralCriteriaBaseBuilder addAsset(List<? extends AssetCriteria> assets) {
			if (assets != null) {
				for (AssetCriteria toAdd : assets) {
					this.asset.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public CollateralCriteriaBase.CollateralCriteriaBaseBuilder setAsset(List<? extends AssetCriteria> assets) {
			if (assets == null)  {
				this.asset = new ArrayList<>();
			}
			else {
				this.asset = assets.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("appliesTo")
		public CollateralCriteriaBase.CollateralCriteriaBaseBuilder addAppliesTo(CounterpartyRoleEnum appliesTo) {
			if (appliesTo!=null) this.appliesTo.add(appliesTo);
			return this;
		}
		
		@Override
		public CollateralCriteriaBase.CollateralCriteriaBaseBuilder addAppliesTo(CounterpartyRoleEnum appliesTo, int _idx) {
			getIndex(this.appliesTo, _idx, () -> appliesTo);
			return this;
		}
		@Override 
		public CollateralCriteriaBase.CollateralCriteriaBaseBuilder addAppliesTo(List<CounterpartyRoleEnum> appliesTos) {
			if (appliesTos != null) {
				for (CounterpartyRoleEnum toAdd : appliesTos) {
					this.appliesTo.add(toAdd);
				}
			}
			return this;
		}
		
		@Override 
		public CollateralCriteriaBase.CollateralCriteriaBaseBuilder setAppliesTo(List<CounterpartyRoleEnum> appliesTos) {
			if (appliesTos == null)  {
				this.appliesTo = new ArrayList<>();
			}
			else {
				this.appliesTo = appliesTos.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("restrictTo")
		public CollateralCriteriaBase.CollateralCriteriaBaseBuilder setRestrictTo(CollateralMarginTypeEnum restrictTo) {
			this.restrictTo = restrictTo==null?null:restrictTo;
			return this;
		}
		@Override
		@RosettaAttribute("ratingPriorityResolution")
		public CollateralCriteriaBase.CollateralCriteriaBaseBuilder setRatingPriorityResolution(RatingPriorityResolutionEnum ratingPriorityResolution) {
			this.ratingPriorityResolution = ratingPriorityResolution==null?null:ratingPriorityResolution;
			return this;
		}
		
		@Override
		public CollateralCriteriaBase build() {
			return new CollateralCriteriaBase.CollateralCriteriaBaseImpl(this);
		}
		
		@Override
		public CollateralCriteriaBase.CollateralCriteriaBaseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralCriteriaBase.CollateralCriteriaBaseBuilder prune() {
			issuer = issuer.stream().filter(b->b!=null).<IssuerCriteria.IssuerCriteriaBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			asset = asset.stream().filter(b->b!=null).<AssetCriteria.AssetCriteriaBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIssuer()!=null && getIssuer().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getAsset()!=null && getAsset().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getAppliesTo()!=null && !getAppliesTo().isEmpty()) return true;
			if (getRestrictTo()!=null) return true;
			if (getRatingPriorityResolution()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralCriteriaBase.CollateralCriteriaBaseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CollateralCriteriaBase.CollateralCriteriaBaseBuilder o = (CollateralCriteriaBase.CollateralCriteriaBaseBuilder) other;
			
			merger.mergeRosetta(getIssuer(), o.getIssuer(), this::getOrCreateIssuer);
			merger.mergeRosetta(getAsset(), o.getAsset(), this::getOrCreateAsset);
			
			merger.mergeBasic(getAppliesTo(), o.getAppliesTo(), (Consumer<CounterpartyRoleEnum>) this::addAppliesTo);
			merger.mergeBasic(getRestrictTo(), o.getRestrictTo(), this::setRestrictTo);
			merger.mergeBasic(getRatingPriorityResolution(), o.getRatingPriorityResolution(), this::setRatingPriorityResolution);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CollateralCriteriaBase _that = getType().cast(o);
		
			if (!ListEquals.listEquals(issuer, _that.getIssuer())) return false;
			if (!ListEquals.listEquals(asset, _that.getAsset())) return false;
			if (!ListEquals.listEquals(appliesTo, _that.getAppliesTo())) return false;
			if (!Objects.equals(restrictTo, _that.getRestrictTo())) return false;
			if (!Objects.equals(ratingPriorityResolution, _that.getRatingPriorityResolution())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (issuer != null ? issuer.hashCode() : 0);
			_result = 31 * _result + (asset != null ? asset.hashCode() : 0);
			_result = 31 * _result + (appliesTo != null ? appliesTo.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			_result = 31 * _result + (restrictTo != null ? restrictTo.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (ratingPriorityResolution != null ? ratingPriorityResolution.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CollateralCriteriaBaseBuilder {" +
				"issuer=" + this.issuer + ", " +
				"asset=" + this.asset + ", " +
				"appliesTo=" + this.appliesTo + ", " +
				"restrictTo=" + this.restrictTo + ", " +
				"ratingPriorityResolution=" + this.ratingPriorityResolution +
			'}';
		}
	}
}
