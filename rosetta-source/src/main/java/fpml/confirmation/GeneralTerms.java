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
import fpml.confirmation.AdditionalTerm;
import fpml.confirmation.AdjustableDate2;
import fpml.confirmation.BasketReferenceInformation;
import fpml.confirmation.BusinessDayAdjustments;
import fpml.confirmation.BuyerSellerModel;
import fpml.confirmation.GeneralTerms;
import fpml.confirmation.GeneralTerms.GeneralTermsBuilder;
import fpml.confirmation.GeneralTerms.GeneralTermsBuilderImpl;
import fpml.confirmation.GeneralTerms.GeneralTermsImpl;
import fpml.confirmation.IndexReferenceInformation;
import fpml.confirmation.ReferenceInformation;
import fpml.confirmation.meta.GeneralTermsMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="GeneralTerms", builder=GeneralTerms.GeneralTermsBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface GeneralTerms extends RosettaModelObject {

	GeneralTermsMeta metaData = new GeneralTermsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The first day of the term of the trade. This day may be subject to adjustment in accordance with a business day convention. ISDA 2003 Term: Effective Date.
	 */
	AdjustableDate2 getEffectiveDate();
	/**
	 * The scheduled date on which the credit protection will lapse. This day may be subject to adjustment in accordance with a business day convention. ISDA 2003 Term: Scheduled Termination Date.
	 */
	AdjustableDate2 getScheduledTerminationDate();
	BuyerSellerModel getBuyerSellerModel();
	/**
	 * ISDA 2003 Terms: Business Day and Business Day Convention.
	 */
	BusinessDayAdjustments getDateAdjustments();
	/**
	 * This element contains all the terms relevant to defining the reference entity and reference obligation(s).
	 */
	ReferenceInformation getReferenceInformation();
	/**
	 * This element contains all the terms relevant to defining the Credit DefaultSwap Index.
	 */
	IndexReferenceInformation getIndexReferenceInformation();
	/**
	 * This element contains all the terms relevant to defining the Credit Default Swap Basket.
	 */
	BasketReferenceInformation getBasketReferenceInformation();
	/**
	 * This element is used for representing information contained in the Additional Terms field of the 2003 Master Credit Derivatives confirm.
	 */
	List<? extends AdditionalTerm> getAdditionalTerm();
	/**
	 * Value of this element set to &#39;true&#39; indicates that substitution is applicable.
	 */
	Boolean getSubstitution();
	/**
	 * Value of this element set to &#39;true&#39; indicates that modified equity delivery is applicable.
	 */
	Boolean getModifiedEquityDelivery();

	/*********************** Build Methods  ***********************/
	GeneralTerms build();
	
	GeneralTerms.GeneralTermsBuilder toBuilder();
	
	static GeneralTerms.GeneralTermsBuilder builder() {
		return new GeneralTerms.GeneralTermsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends GeneralTerms> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends GeneralTerms> getType() {
		return GeneralTerms.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("effectiveDate"), processor, AdjustableDate2.class, getEffectiveDate());
		processRosetta(path.newSubPath("scheduledTerminationDate"), processor, AdjustableDate2.class, getScheduledTerminationDate());
		processRosetta(path.newSubPath("buyerSellerModel"), processor, BuyerSellerModel.class, getBuyerSellerModel());
		processRosetta(path.newSubPath("dateAdjustments"), processor, BusinessDayAdjustments.class, getDateAdjustments());
		processRosetta(path.newSubPath("referenceInformation"), processor, ReferenceInformation.class, getReferenceInformation());
		processRosetta(path.newSubPath("indexReferenceInformation"), processor, IndexReferenceInformation.class, getIndexReferenceInformation());
		processRosetta(path.newSubPath("basketReferenceInformation"), processor, BasketReferenceInformation.class, getBasketReferenceInformation());
		processRosetta(path.newSubPath("additionalTerm"), processor, AdditionalTerm.class, getAdditionalTerm());
		processor.processBasic(path.newSubPath("substitution"), Boolean.class, getSubstitution(), this);
		processor.processBasic(path.newSubPath("modifiedEquityDelivery"), Boolean.class, getModifiedEquityDelivery(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface GeneralTermsBuilder extends GeneralTerms, RosettaModelObjectBuilder {
		AdjustableDate2.AdjustableDate2Builder getOrCreateEffectiveDate();
		AdjustableDate2.AdjustableDate2Builder getEffectiveDate();
		AdjustableDate2.AdjustableDate2Builder getOrCreateScheduledTerminationDate();
		AdjustableDate2.AdjustableDate2Builder getScheduledTerminationDate();
		BuyerSellerModel.BuyerSellerModelBuilder getOrCreateBuyerSellerModel();
		BuyerSellerModel.BuyerSellerModelBuilder getBuyerSellerModel();
		BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getOrCreateDateAdjustments();
		BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getDateAdjustments();
		ReferenceInformation.ReferenceInformationBuilder getOrCreateReferenceInformation();
		ReferenceInformation.ReferenceInformationBuilder getReferenceInformation();
		IndexReferenceInformation.IndexReferenceInformationBuilder getOrCreateIndexReferenceInformation();
		IndexReferenceInformation.IndexReferenceInformationBuilder getIndexReferenceInformation();
		BasketReferenceInformation.BasketReferenceInformationBuilder getOrCreateBasketReferenceInformation();
		BasketReferenceInformation.BasketReferenceInformationBuilder getBasketReferenceInformation();
		AdditionalTerm.AdditionalTermBuilder getOrCreateAdditionalTerm(int _index);
		List<? extends AdditionalTerm.AdditionalTermBuilder> getAdditionalTerm();
		GeneralTerms.GeneralTermsBuilder setEffectiveDate(AdjustableDate2 effectiveDate);
		GeneralTerms.GeneralTermsBuilder setScheduledTerminationDate(AdjustableDate2 scheduledTerminationDate);
		GeneralTerms.GeneralTermsBuilder setBuyerSellerModel(BuyerSellerModel buyerSellerModel);
		GeneralTerms.GeneralTermsBuilder setDateAdjustments(BusinessDayAdjustments dateAdjustments);
		GeneralTerms.GeneralTermsBuilder setReferenceInformation(ReferenceInformation referenceInformation);
		GeneralTerms.GeneralTermsBuilder setIndexReferenceInformation(IndexReferenceInformation indexReferenceInformation);
		GeneralTerms.GeneralTermsBuilder setBasketReferenceInformation(BasketReferenceInformation basketReferenceInformation);
		GeneralTerms.GeneralTermsBuilder addAdditionalTerm(AdditionalTerm additionalTerm0);
		GeneralTerms.GeneralTermsBuilder addAdditionalTerm(AdditionalTerm additionalTerm1, int _idx);
		GeneralTerms.GeneralTermsBuilder addAdditionalTerm(List<? extends AdditionalTerm> additionalTerm2);
		GeneralTerms.GeneralTermsBuilder setAdditionalTerm(List<? extends AdditionalTerm> additionalTerm3);
		GeneralTerms.GeneralTermsBuilder setSubstitution(Boolean substitution);
		GeneralTerms.GeneralTermsBuilder setModifiedEquityDelivery(Boolean modifiedEquityDelivery);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("effectiveDate"), processor, AdjustableDate2.AdjustableDate2Builder.class, getEffectiveDate());
			processRosetta(path.newSubPath("scheduledTerminationDate"), processor, AdjustableDate2.AdjustableDate2Builder.class, getScheduledTerminationDate());
			processRosetta(path.newSubPath("buyerSellerModel"), processor, BuyerSellerModel.BuyerSellerModelBuilder.class, getBuyerSellerModel());
			processRosetta(path.newSubPath("dateAdjustments"), processor, BusinessDayAdjustments.BusinessDayAdjustmentsBuilder.class, getDateAdjustments());
			processRosetta(path.newSubPath("referenceInformation"), processor, ReferenceInformation.ReferenceInformationBuilder.class, getReferenceInformation());
			processRosetta(path.newSubPath("indexReferenceInformation"), processor, IndexReferenceInformation.IndexReferenceInformationBuilder.class, getIndexReferenceInformation());
			processRosetta(path.newSubPath("basketReferenceInformation"), processor, BasketReferenceInformation.BasketReferenceInformationBuilder.class, getBasketReferenceInformation());
			processRosetta(path.newSubPath("additionalTerm"), processor, AdditionalTerm.AdditionalTermBuilder.class, getAdditionalTerm());
			processor.processBasic(path.newSubPath("substitution"), Boolean.class, getSubstitution(), this);
			processor.processBasic(path.newSubPath("modifiedEquityDelivery"), Boolean.class, getModifiedEquityDelivery(), this);
		}
		

		GeneralTerms.GeneralTermsBuilder prune();
	}

	/*********************** Immutable Implementation of GeneralTerms  ***********************/
	class GeneralTermsImpl implements GeneralTerms {
		private final AdjustableDate2 effectiveDate;
		private final AdjustableDate2 scheduledTerminationDate;
		private final BuyerSellerModel buyerSellerModel;
		private final BusinessDayAdjustments dateAdjustments;
		private final ReferenceInformation referenceInformation;
		private final IndexReferenceInformation indexReferenceInformation;
		private final BasketReferenceInformation basketReferenceInformation;
		private final List<? extends AdditionalTerm> additionalTerm;
		private final Boolean substitution;
		private final Boolean modifiedEquityDelivery;
		
		protected GeneralTermsImpl(GeneralTerms.GeneralTermsBuilder builder) {
			this.effectiveDate = ofNullable(builder.getEffectiveDate()).map(f->f.build()).orElse(null);
			this.scheduledTerminationDate = ofNullable(builder.getScheduledTerminationDate()).map(f->f.build()).orElse(null);
			this.buyerSellerModel = ofNullable(builder.getBuyerSellerModel()).map(f->f.build()).orElse(null);
			this.dateAdjustments = ofNullable(builder.getDateAdjustments()).map(f->f.build()).orElse(null);
			this.referenceInformation = ofNullable(builder.getReferenceInformation()).map(f->f.build()).orElse(null);
			this.indexReferenceInformation = ofNullable(builder.getIndexReferenceInformation()).map(f->f.build()).orElse(null);
			this.basketReferenceInformation = ofNullable(builder.getBasketReferenceInformation()).map(f->f.build()).orElse(null);
			this.additionalTerm = ofNullable(builder.getAdditionalTerm()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.substitution = builder.getSubstitution();
			this.modifiedEquityDelivery = builder.getModifiedEquityDelivery();
		}
		
		@Override
		@RosettaAttribute("effectiveDate")
		public AdjustableDate2 getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		@RosettaAttribute("scheduledTerminationDate")
		public AdjustableDate2 getScheduledTerminationDate() {
			return scheduledTerminationDate;
		}
		
		@Override
		@RosettaAttribute("buyerSellerModel")
		public BuyerSellerModel getBuyerSellerModel() {
			return buyerSellerModel;
		}
		
		@Override
		@RosettaAttribute("dateAdjustments")
		public BusinessDayAdjustments getDateAdjustments() {
			return dateAdjustments;
		}
		
		@Override
		@RosettaAttribute("referenceInformation")
		public ReferenceInformation getReferenceInformation() {
			return referenceInformation;
		}
		
		@Override
		@RosettaAttribute("indexReferenceInformation")
		public IndexReferenceInformation getIndexReferenceInformation() {
			return indexReferenceInformation;
		}
		
		@Override
		@RosettaAttribute("basketReferenceInformation")
		public BasketReferenceInformation getBasketReferenceInformation() {
			return basketReferenceInformation;
		}
		
		@Override
		@RosettaAttribute("additionalTerm")
		public List<? extends AdditionalTerm> getAdditionalTerm() {
			return additionalTerm;
		}
		
		@Override
		@RosettaAttribute("substitution")
		public Boolean getSubstitution() {
			return substitution;
		}
		
		@Override
		@RosettaAttribute("modifiedEquityDelivery")
		public Boolean getModifiedEquityDelivery() {
			return modifiedEquityDelivery;
		}
		
		@Override
		public GeneralTerms build() {
			return this;
		}
		
		@Override
		public GeneralTerms.GeneralTermsBuilder toBuilder() {
			GeneralTerms.GeneralTermsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(GeneralTerms.GeneralTermsBuilder builder) {
			ofNullable(getEffectiveDate()).ifPresent(builder::setEffectiveDate);
			ofNullable(getScheduledTerminationDate()).ifPresent(builder::setScheduledTerminationDate);
			ofNullable(getBuyerSellerModel()).ifPresent(builder::setBuyerSellerModel);
			ofNullable(getDateAdjustments()).ifPresent(builder::setDateAdjustments);
			ofNullable(getReferenceInformation()).ifPresent(builder::setReferenceInformation);
			ofNullable(getIndexReferenceInformation()).ifPresent(builder::setIndexReferenceInformation);
			ofNullable(getBasketReferenceInformation()).ifPresent(builder::setBasketReferenceInformation);
			ofNullable(getAdditionalTerm()).ifPresent(builder::setAdditionalTerm);
			ofNullable(getSubstitution()).ifPresent(builder::setSubstitution);
			ofNullable(getModifiedEquityDelivery()).ifPresent(builder::setModifiedEquityDelivery);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			GeneralTerms _that = getType().cast(o);
		
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(scheduledTerminationDate, _that.getScheduledTerminationDate())) return false;
			if (!Objects.equals(buyerSellerModel, _that.getBuyerSellerModel())) return false;
			if (!Objects.equals(dateAdjustments, _that.getDateAdjustments())) return false;
			if (!Objects.equals(referenceInformation, _that.getReferenceInformation())) return false;
			if (!Objects.equals(indexReferenceInformation, _that.getIndexReferenceInformation())) return false;
			if (!Objects.equals(basketReferenceInformation, _that.getBasketReferenceInformation())) return false;
			if (!ListEquals.listEquals(additionalTerm, _that.getAdditionalTerm())) return false;
			if (!Objects.equals(substitution, _that.getSubstitution())) return false;
			if (!Objects.equals(modifiedEquityDelivery, _that.getModifiedEquityDelivery())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (scheduledTerminationDate != null ? scheduledTerminationDate.hashCode() : 0);
			_result = 31 * _result + (buyerSellerModel != null ? buyerSellerModel.hashCode() : 0);
			_result = 31 * _result + (dateAdjustments != null ? dateAdjustments.hashCode() : 0);
			_result = 31 * _result + (referenceInformation != null ? referenceInformation.hashCode() : 0);
			_result = 31 * _result + (indexReferenceInformation != null ? indexReferenceInformation.hashCode() : 0);
			_result = 31 * _result + (basketReferenceInformation != null ? basketReferenceInformation.hashCode() : 0);
			_result = 31 * _result + (additionalTerm != null ? additionalTerm.hashCode() : 0);
			_result = 31 * _result + (substitution != null ? substitution.hashCode() : 0);
			_result = 31 * _result + (modifiedEquityDelivery != null ? modifiedEquityDelivery.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GeneralTerms {" +
				"effectiveDate=" + this.effectiveDate + ", " +
				"scheduledTerminationDate=" + this.scheduledTerminationDate + ", " +
				"buyerSellerModel=" + this.buyerSellerModel + ", " +
				"dateAdjustments=" + this.dateAdjustments + ", " +
				"referenceInformation=" + this.referenceInformation + ", " +
				"indexReferenceInformation=" + this.indexReferenceInformation + ", " +
				"basketReferenceInformation=" + this.basketReferenceInformation + ", " +
				"additionalTerm=" + this.additionalTerm + ", " +
				"substitution=" + this.substitution + ", " +
				"modifiedEquityDelivery=" + this.modifiedEquityDelivery +
			'}';
		}
	}

	/*********************** Builder Implementation of GeneralTerms  ***********************/
	class GeneralTermsBuilderImpl implements GeneralTerms.GeneralTermsBuilder {
	
		protected AdjustableDate2.AdjustableDate2Builder effectiveDate;
		protected AdjustableDate2.AdjustableDate2Builder scheduledTerminationDate;
		protected BuyerSellerModel.BuyerSellerModelBuilder buyerSellerModel;
		protected BusinessDayAdjustments.BusinessDayAdjustmentsBuilder dateAdjustments;
		protected ReferenceInformation.ReferenceInformationBuilder referenceInformation;
		protected IndexReferenceInformation.IndexReferenceInformationBuilder indexReferenceInformation;
		protected BasketReferenceInformation.BasketReferenceInformationBuilder basketReferenceInformation;
		protected List<AdditionalTerm.AdditionalTermBuilder> additionalTerm = new ArrayList<>();
		protected Boolean substitution;
		protected Boolean modifiedEquityDelivery;
	
		public GeneralTermsBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("effectiveDate")
		public AdjustableDate2.AdjustableDate2Builder getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		public AdjustableDate2.AdjustableDate2Builder getOrCreateEffectiveDate() {
			AdjustableDate2.AdjustableDate2Builder result;
			if (effectiveDate!=null) {
				result = effectiveDate;
			}
			else {
				result = effectiveDate = AdjustableDate2.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("scheduledTerminationDate")
		public AdjustableDate2.AdjustableDate2Builder getScheduledTerminationDate() {
			return scheduledTerminationDate;
		}
		
		@Override
		public AdjustableDate2.AdjustableDate2Builder getOrCreateScheduledTerminationDate() {
			AdjustableDate2.AdjustableDate2Builder result;
			if (scheduledTerminationDate!=null) {
				result = scheduledTerminationDate;
			}
			else {
				result = scheduledTerminationDate = AdjustableDate2.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("buyerSellerModel")
		public BuyerSellerModel.BuyerSellerModelBuilder getBuyerSellerModel() {
			return buyerSellerModel;
		}
		
		@Override
		public BuyerSellerModel.BuyerSellerModelBuilder getOrCreateBuyerSellerModel() {
			BuyerSellerModel.BuyerSellerModelBuilder result;
			if (buyerSellerModel!=null) {
				result = buyerSellerModel;
			}
			else {
				result = buyerSellerModel = BuyerSellerModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("dateAdjustments")
		public BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getDateAdjustments() {
			return dateAdjustments;
		}
		
		@Override
		public BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getOrCreateDateAdjustments() {
			BusinessDayAdjustments.BusinessDayAdjustmentsBuilder result;
			if (dateAdjustments!=null) {
				result = dateAdjustments;
			}
			else {
				result = dateAdjustments = BusinessDayAdjustments.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("referenceInformation")
		public ReferenceInformation.ReferenceInformationBuilder getReferenceInformation() {
			return referenceInformation;
		}
		
		@Override
		public ReferenceInformation.ReferenceInformationBuilder getOrCreateReferenceInformation() {
			ReferenceInformation.ReferenceInformationBuilder result;
			if (referenceInformation!=null) {
				result = referenceInformation;
			}
			else {
				result = referenceInformation = ReferenceInformation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("indexReferenceInformation")
		public IndexReferenceInformation.IndexReferenceInformationBuilder getIndexReferenceInformation() {
			return indexReferenceInformation;
		}
		
		@Override
		public IndexReferenceInformation.IndexReferenceInformationBuilder getOrCreateIndexReferenceInformation() {
			IndexReferenceInformation.IndexReferenceInformationBuilder result;
			if (indexReferenceInformation!=null) {
				result = indexReferenceInformation;
			}
			else {
				result = indexReferenceInformation = IndexReferenceInformation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("basketReferenceInformation")
		public BasketReferenceInformation.BasketReferenceInformationBuilder getBasketReferenceInformation() {
			return basketReferenceInformation;
		}
		
		@Override
		public BasketReferenceInformation.BasketReferenceInformationBuilder getOrCreateBasketReferenceInformation() {
			BasketReferenceInformation.BasketReferenceInformationBuilder result;
			if (basketReferenceInformation!=null) {
				result = basketReferenceInformation;
			}
			else {
				result = basketReferenceInformation = BasketReferenceInformation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("additionalTerm")
		public List<? extends AdditionalTerm.AdditionalTermBuilder> getAdditionalTerm() {
			return additionalTerm;
		}
		
		@Override
		public AdditionalTerm.AdditionalTermBuilder getOrCreateAdditionalTerm(int _index) {
		
			if (additionalTerm==null) {
				this.additionalTerm = new ArrayList<>();
			}
			AdditionalTerm.AdditionalTermBuilder result;
			return getIndex(additionalTerm, _index, () -> {
						AdditionalTerm.AdditionalTermBuilder newAdditionalTerm = AdditionalTerm.builder();
						return newAdditionalTerm;
					});
		}
		
		@Override
		@RosettaAttribute("substitution")
		public Boolean getSubstitution() {
			return substitution;
		}
		
		@Override
		@RosettaAttribute("modifiedEquityDelivery")
		public Boolean getModifiedEquityDelivery() {
			return modifiedEquityDelivery;
		}
		
		@Override
		@RosettaAttribute("effectiveDate")
		public GeneralTerms.GeneralTermsBuilder setEffectiveDate(AdjustableDate2 effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("scheduledTerminationDate")
		public GeneralTerms.GeneralTermsBuilder setScheduledTerminationDate(AdjustableDate2 scheduledTerminationDate) {
			this.scheduledTerminationDate = scheduledTerminationDate==null?null:scheduledTerminationDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("buyerSellerModel")
		public GeneralTerms.GeneralTermsBuilder setBuyerSellerModel(BuyerSellerModel buyerSellerModel) {
			this.buyerSellerModel = buyerSellerModel==null?null:buyerSellerModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("dateAdjustments")
		public GeneralTerms.GeneralTermsBuilder setDateAdjustments(BusinessDayAdjustments dateAdjustments) {
			this.dateAdjustments = dateAdjustments==null?null:dateAdjustments.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("referenceInformation")
		public GeneralTerms.GeneralTermsBuilder setReferenceInformation(ReferenceInformation referenceInformation) {
			this.referenceInformation = referenceInformation==null?null:referenceInformation.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("indexReferenceInformation")
		public GeneralTerms.GeneralTermsBuilder setIndexReferenceInformation(IndexReferenceInformation indexReferenceInformation) {
			this.indexReferenceInformation = indexReferenceInformation==null?null:indexReferenceInformation.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("basketReferenceInformation")
		public GeneralTerms.GeneralTermsBuilder setBasketReferenceInformation(BasketReferenceInformation basketReferenceInformation) {
			this.basketReferenceInformation = basketReferenceInformation==null?null:basketReferenceInformation.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("additionalTerm")
		public GeneralTerms.GeneralTermsBuilder addAdditionalTerm(AdditionalTerm additionalTerm) {
			if (additionalTerm!=null) this.additionalTerm.add(additionalTerm.toBuilder());
			return this;
		}
		
		@Override
		public GeneralTerms.GeneralTermsBuilder addAdditionalTerm(AdditionalTerm additionalTerm, int _idx) {
			getIndex(this.additionalTerm, _idx, () -> additionalTerm.toBuilder());
			return this;
		}
		@Override 
		public GeneralTerms.GeneralTermsBuilder addAdditionalTerm(List<? extends AdditionalTerm> additionalTerms) {
			if (additionalTerms != null) {
				for (AdditionalTerm toAdd : additionalTerms) {
					this.additionalTerm.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public GeneralTerms.GeneralTermsBuilder setAdditionalTerm(List<? extends AdditionalTerm> additionalTerms) {
			if (additionalTerms == null)  {
				this.additionalTerm = new ArrayList<>();
			}
			else {
				this.additionalTerm = additionalTerms.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("substitution")
		public GeneralTerms.GeneralTermsBuilder setSubstitution(Boolean substitution) {
			this.substitution = substitution==null?null:substitution;
			return this;
		}
		@Override
		@RosettaAttribute("modifiedEquityDelivery")
		public GeneralTerms.GeneralTermsBuilder setModifiedEquityDelivery(Boolean modifiedEquityDelivery) {
			this.modifiedEquityDelivery = modifiedEquityDelivery==null?null:modifiedEquityDelivery;
			return this;
		}
		
		@Override
		public GeneralTerms build() {
			return new GeneralTerms.GeneralTermsImpl(this);
		}
		
		@Override
		public GeneralTerms.GeneralTermsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GeneralTerms.GeneralTermsBuilder prune() {
			if (effectiveDate!=null && !effectiveDate.prune().hasData()) effectiveDate = null;
			if (scheduledTerminationDate!=null && !scheduledTerminationDate.prune().hasData()) scheduledTerminationDate = null;
			if (buyerSellerModel!=null && !buyerSellerModel.prune().hasData()) buyerSellerModel = null;
			if (dateAdjustments!=null && !dateAdjustments.prune().hasData()) dateAdjustments = null;
			if (referenceInformation!=null && !referenceInformation.prune().hasData()) referenceInformation = null;
			if (indexReferenceInformation!=null && !indexReferenceInformation.prune().hasData()) indexReferenceInformation = null;
			if (basketReferenceInformation!=null && !basketReferenceInformation.prune().hasData()) basketReferenceInformation = null;
			additionalTerm = additionalTerm.stream().filter(b->b!=null).<AdditionalTerm.AdditionalTermBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getEffectiveDate()!=null && getEffectiveDate().hasData()) return true;
			if (getScheduledTerminationDate()!=null && getScheduledTerminationDate().hasData()) return true;
			if (getBuyerSellerModel()!=null && getBuyerSellerModel().hasData()) return true;
			if (getDateAdjustments()!=null && getDateAdjustments().hasData()) return true;
			if (getReferenceInformation()!=null && getReferenceInformation().hasData()) return true;
			if (getIndexReferenceInformation()!=null && getIndexReferenceInformation().hasData()) return true;
			if (getBasketReferenceInformation()!=null && getBasketReferenceInformation().hasData()) return true;
			if (getAdditionalTerm()!=null && getAdditionalTerm().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getSubstitution()!=null) return true;
			if (getModifiedEquityDelivery()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GeneralTerms.GeneralTermsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			GeneralTerms.GeneralTermsBuilder o = (GeneralTerms.GeneralTermsBuilder) other;
			
			merger.mergeRosetta(getEffectiveDate(), o.getEffectiveDate(), this::setEffectiveDate);
			merger.mergeRosetta(getScheduledTerminationDate(), o.getScheduledTerminationDate(), this::setScheduledTerminationDate);
			merger.mergeRosetta(getBuyerSellerModel(), o.getBuyerSellerModel(), this::setBuyerSellerModel);
			merger.mergeRosetta(getDateAdjustments(), o.getDateAdjustments(), this::setDateAdjustments);
			merger.mergeRosetta(getReferenceInformation(), o.getReferenceInformation(), this::setReferenceInformation);
			merger.mergeRosetta(getIndexReferenceInformation(), o.getIndexReferenceInformation(), this::setIndexReferenceInformation);
			merger.mergeRosetta(getBasketReferenceInformation(), o.getBasketReferenceInformation(), this::setBasketReferenceInformation);
			merger.mergeRosetta(getAdditionalTerm(), o.getAdditionalTerm(), this::getOrCreateAdditionalTerm);
			
			merger.mergeBasic(getSubstitution(), o.getSubstitution(), this::setSubstitution);
			merger.mergeBasic(getModifiedEquityDelivery(), o.getModifiedEquityDelivery(), this::setModifiedEquityDelivery);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			GeneralTerms _that = getType().cast(o);
		
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(scheduledTerminationDate, _that.getScheduledTerminationDate())) return false;
			if (!Objects.equals(buyerSellerModel, _that.getBuyerSellerModel())) return false;
			if (!Objects.equals(dateAdjustments, _that.getDateAdjustments())) return false;
			if (!Objects.equals(referenceInformation, _that.getReferenceInformation())) return false;
			if (!Objects.equals(indexReferenceInformation, _that.getIndexReferenceInformation())) return false;
			if (!Objects.equals(basketReferenceInformation, _that.getBasketReferenceInformation())) return false;
			if (!ListEquals.listEquals(additionalTerm, _that.getAdditionalTerm())) return false;
			if (!Objects.equals(substitution, _that.getSubstitution())) return false;
			if (!Objects.equals(modifiedEquityDelivery, _that.getModifiedEquityDelivery())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (scheduledTerminationDate != null ? scheduledTerminationDate.hashCode() : 0);
			_result = 31 * _result + (buyerSellerModel != null ? buyerSellerModel.hashCode() : 0);
			_result = 31 * _result + (dateAdjustments != null ? dateAdjustments.hashCode() : 0);
			_result = 31 * _result + (referenceInformation != null ? referenceInformation.hashCode() : 0);
			_result = 31 * _result + (indexReferenceInformation != null ? indexReferenceInformation.hashCode() : 0);
			_result = 31 * _result + (basketReferenceInformation != null ? basketReferenceInformation.hashCode() : 0);
			_result = 31 * _result + (additionalTerm != null ? additionalTerm.hashCode() : 0);
			_result = 31 * _result + (substitution != null ? substitution.hashCode() : 0);
			_result = 31 * _result + (modifiedEquityDelivery != null ? modifiedEquityDelivery.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GeneralTermsBuilder {" +
				"effectiveDate=" + this.effectiveDate + ", " +
				"scheduledTerminationDate=" + this.scheduledTerminationDate + ", " +
				"buyerSellerModel=" + this.buyerSellerModel + ", " +
				"dateAdjustments=" + this.dateAdjustments + ", " +
				"referenceInformation=" + this.referenceInformation + ", " +
				"indexReferenceInformation=" + this.indexReferenceInformation + ", " +
				"basketReferenceInformation=" + this.basketReferenceInformation + ", " +
				"additionalTerm=" + this.additionalTerm + ", " +
				"substitution=" + this.substitution + ", " +
				"modifiedEquityDelivery=" + this.modifiedEquityDelivery +
			'}';
		}
	}
}
