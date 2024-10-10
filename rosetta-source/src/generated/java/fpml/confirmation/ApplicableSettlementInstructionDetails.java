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
import fpml.confirmation.AbstractApplicablePartyProfileObjects;
import fpml.confirmation.AbstractApplicablePartyProfileObjects.AbstractApplicablePartyProfileObjectsBuilder;
import fpml.confirmation.AbstractApplicablePartyProfileObjects.AbstractApplicablePartyProfileObjectsBuilderImpl;
import fpml.confirmation.AbstractApplicablePartyProfileObjects.AbstractApplicablePartyProfileObjectsImpl;
import fpml.confirmation.ApplicableAssets;
import fpml.confirmation.ApplicableSettlementInstructionDetails;
import fpml.confirmation.ApplicableSettlementInstructionDetails.ApplicableSettlementInstructionDetailsBuilder;
import fpml.confirmation.ApplicableSettlementInstructionDetails.ApplicableSettlementInstructionDetailsBuilderImpl;
import fpml.confirmation.ApplicableSettlementInstructionDetails.ApplicableSettlementInstructionDetailsImpl;
import fpml.confirmation.ApplicableTransactionType;
import fpml.confirmation.AssociationToAssetIdentifier;
import fpml.confirmation.SettlementDetails;
import fpml.confirmation.meta.ApplicableSettlementInstructionDetailsMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A structure that defines the assets (or type of assets) that a particular set of settlement instrution details may be associated with.
 * @version ${project.version}
 */
@RosettaDataType(value="ApplicableSettlementInstructionDetails", builder=ApplicableSettlementInstructionDetails.ApplicableSettlementInstructionDetailsBuilderImpl.class, version="${project.version}")
public interface ApplicableSettlementInstructionDetails extends AbstractApplicablePartyProfileObjects {

	ApplicableSettlementInstructionDetailsMeta metaData = new ApplicableSettlementInstructionDetailsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Settlement account details to describe the acount to which cash should be sent, for payments received by the party sending the Lender Party Notification.
	 */
	List<? extends SettlementDetails> getSettlementDetails();

	/*********************** Build Methods  ***********************/
	ApplicableSettlementInstructionDetails build();
	
	ApplicableSettlementInstructionDetails.ApplicableSettlementInstructionDetailsBuilder toBuilder();
	
	static ApplicableSettlementInstructionDetails.ApplicableSettlementInstructionDetailsBuilder builder() {
		return new ApplicableSettlementInstructionDetails.ApplicableSettlementInstructionDetailsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ApplicableSettlementInstructionDetails> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ApplicableSettlementInstructionDetails> getType() {
		return ApplicableSettlementInstructionDetails.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("identifier"), processor, AssociationToAssetIdentifier.class, getIdentifier());
		processRosetta(path.newSubPath("applicableAssets"), processor, ApplicableAssets.class, getApplicableAssets());
		processRosetta(path.newSubPath("applicableTransactions"), processor, ApplicableTransactionType.class, getApplicableTransactions());
		processRosetta(path.newSubPath("settlementDetails"), processor, SettlementDetails.class, getSettlementDetails());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ApplicableSettlementInstructionDetailsBuilder extends ApplicableSettlementInstructionDetails, AbstractApplicablePartyProfileObjects.AbstractApplicablePartyProfileObjectsBuilder {
		SettlementDetails.SettlementDetailsBuilder getOrCreateSettlementDetails(int _index);
		List<? extends SettlementDetails.SettlementDetailsBuilder> getSettlementDetails();
		ApplicableSettlementInstructionDetails.ApplicableSettlementInstructionDetailsBuilder setIdentifier(AssociationToAssetIdentifier identifier);
		ApplicableSettlementInstructionDetails.ApplicableSettlementInstructionDetailsBuilder setApplicableAssets(ApplicableAssets applicableAssets);
		ApplicableSettlementInstructionDetails.ApplicableSettlementInstructionDetailsBuilder addApplicableTransactions(ApplicableTransactionType applicableTransactions0);
		ApplicableSettlementInstructionDetails.ApplicableSettlementInstructionDetailsBuilder addApplicableTransactions(ApplicableTransactionType applicableTransactions1, int _idx);
		ApplicableSettlementInstructionDetails.ApplicableSettlementInstructionDetailsBuilder addApplicableTransactions(List<? extends ApplicableTransactionType> applicableTransactions2);
		ApplicableSettlementInstructionDetails.ApplicableSettlementInstructionDetailsBuilder setApplicableTransactions(List<? extends ApplicableTransactionType> applicableTransactions3);
		ApplicableSettlementInstructionDetails.ApplicableSettlementInstructionDetailsBuilder addSettlementDetails(SettlementDetails settlementDetails0);
		ApplicableSettlementInstructionDetails.ApplicableSettlementInstructionDetailsBuilder addSettlementDetails(SettlementDetails settlementDetails1, int _idx);
		ApplicableSettlementInstructionDetails.ApplicableSettlementInstructionDetailsBuilder addSettlementDetails(List<? extends SettlementDetails> settlementDetails2);
		ApplicableSettlementInstructionDetails.ApplicableSettlementInstructionDetailsBuilder setSettlementDetails(List<? extends SettlementDetails> settlementDetails3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("identifier"), processor, AssociationToAssetIdentifier.AssociationToAssetIdentifierBuilder.class, getIdentifier());
			processRosetta(path.newSubPath("applicableAssets"), processor, ApplicableAssets.ApplicableAssetsBuilder.class, getApplicableAssets());
			processRosetta(path.newSubPath("applicableTransactions"), processor, ApplicableTransactionType.ApplicableTransactionTypeBuilder.class, getApplicableTransactions());
			processRosetta(path.newSubPath("settlementDetails"), processor, SettlementDetails.SettlementDetailsBuilder.class, getSettlementDetails());
		}
		

		ApplicableSettlementInstructionDetails.ApplicableSettlementInstructionDetailsBuilder prune();
	}

	/*********************** Immutable Implementation of ApplicableSettlementInstructionDetails  ***********************/
	class ApplicableSettlementInstructionDetailsImpl extends AbstractApplicablePartyProfileObjects.AbstractApplicablePartyProfileObjectsImpl implements ApplicableSettlementInstructionDetails {
		private final List<? extends SettlementDetails> settlementDetails;
		
		protected ApplicableSettlementInstructionDetailsImpl(ApplicableSettlementInstructionDetails.ApplicableSettlementInstructionDetailsBuilder builder) {
			super(builder);
			this.settlementDetails = ofNullable(builder.getSettlementDetails()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("settlementDetails")
		public List<? extends SettlementDetails> getSettlementDetails() {
			return settlementDetails;
		}
		
		@Override
		public ApplicableSettlementInstructionDetails build() {
			return this;
		}
		
		@Override
		public ApplicableSettlementInstructionDetails.ApplicableSettlementInstructionDetailsBuilder toBuilder() {
			ApplicableSettlementInstructionDetails.ApplicableSettlementInstructionDetailsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ApplicableSettlementInstructionDetails.ApplicableSettlementInstructionDetailsBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getSettlementDetails()).ifPresent(builder::setSettlementDetails);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ApplicableSettlementInstructionDetails _that = getType().cast(o);
		
			if (!ListEquals.listEquals(settlementDetails, _that.getSettlementDetails())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (settlementDetails != null ? settlementDetails.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ApplicableSettlementInstructionDetails {" +
				"settlementDetails=" + this.settlementDetails +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ApplicableSettlementInstructionDetails  ***********************/
	class ApplicableSettlementInstructionDetailsBuilderImpl extends AbstractApplicablePartyProfileObjects.AbstractApplicablePartyProfileObjectsBuilderImpl  implements ApplicableSettlementInstructionDetails.ApplicableSettlementInstructionDetailsBuilder {
	
		protected List<SettlementDetails.SettlementDetailsBuilder> settlementDetails = new ArrayList<>();
	
		public ApplicableSettlementInstructionDetailsBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("settlementDetails")
		public List<? extends SettlementDetails.SettlementDetailsBuilder> getSettlementDetails() {
			return settlementDetails;
		}
		
		public SettlementDetails.SettlementDetailsBuilder getOrCreateSettlementDetails(int _index) {
		
			if (settlementDetails==null) {
				this.settlementDetails = new ArrayList<>();
			}
			SettlementDetails.SettlementDetailsBuilder result;
			return getIndex(settlementDetails, _index, () -> {
						SettlementDetails.SettlementDetailsBuilder newSettlementDetails = SettlementDetails.builder();
						return newSettlementDetails;
					});
		}
		
		@Override
		@RosettaAttribute("identifier")
		public ApplicableSettlementInstructionDetails.ApplicableSettlementInstructionDetailsBuilder setIdentifier(AssociationToAssetIdentifier identifier) {
			this.identifier = identifier==null?null:identifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("applicableAssets")
		public ApplicableSettlementInstructionDetails.ApplicableSettlementInstructionDetailsBuilder setApplicableAssets(ApplicableAssets applicableAssets) {
			this.applicableAssets = applicableAssets==null?null:applicableAssets.toBuilder();
			return this;
		}
		@Override
		public ApplicableSettlementInstructionDetails.ApplicableSettlementInstructionDetailsBuilder addApplicableTransactions(ApplicableTransactionType applicableTransactions) {
			if (applicableTransactions!=null) this.applicableTransactions.add(applicableTransactions.toBuilder());
			return this;
		}
		
		@Override
		public ApplicableSettlementInstructionDetails.ApplicableSettlementInstructionDetailsBuilder addApplicableTransactions(ApplicableTransactionType applicableTransactions, int _idx) {
			getIndex(this.applicableTransactions, _idx, () -> applicableTransactions.toBuilder());
			return this;
		}
		@Override 
		public ApplicableSettlementInstructionDetails.ApplicableSettlementInstructionDetailsBuilder addApplicableTransactions(List<? extends ApplicableTransactionType> applicableTransactionss) {
			if (applicableTransactionss != null) {
				for (ApplicableTransactionType toAdd : applicableTransactionss) {
					this.applicableTransactions.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("applicableTransactions")
		public ApplicableSettlementInstructionDetails.ApplicableSettlementInstructionDetailsBuilder setApplicableTransactions(List<? extends ApplicableTransactionType> applicableTransactionss) {
			if (applicableTransactionss == null)  {
				this.applicableTransactions = new ArrayList<>();
			}
			else {
				this.applicableTransactions = applicableTransactionss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public ApplicableSettlementInstructionDetails.ApplicableSettlementInstructionDetailsBuilder addSettlementDetails(SettlementDetails settlementDetails) {
			if (settlementDetails!=null) this.settlementDetails.add(settlementDetails.toBuilder());
			return this;
		}
		
		@Override
		public ApplicableSettlementInstructionDetails.ApplicableSettlementInstructionDetailsBuilder addSettlementDetails(SettlementDetails settlementDetails, int _idx) {
			getIndex(this.settlementDetails, _idx, () -> settlementDetails.toBuilder());
			return this;
		}
		@Override 
		public ApplicableSettlementInstructionDetails.ApplicableSettlementInstructionDetailsBuilder addSettlementDetails(List<? extends SettlementDetails> settlementDetailss) {
			if (settlementDetailss != null) {
				for (SettlementDetails toAdd : settlementDetailss) {
					this.settlementDetails.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("settlementDetails")
		public ApplicableSettlementInstructionDetails.ApplicableSettlementInstructionDetailsBuilder setSettlementDetails(List<? extends SettlementDetails> settlementDetailss) {
			if (settlementDetailss == null)  {
				this.settlementDetails = new ArrayList<>();
			}
			else {
				this.settlementDetails = settlementDetailss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public ApplicableSettlementInstructionDetails build() {
			return new ApplicableSettlementInstructionDetails.ApplicableSettlementInstructionDetailsImpl(this);
		}
		
		@Override
		public ApplicableSettlementInstructionDetails.ApplicableSettlementInstructionDetailsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ApplicableSettlementInstructionDetails.ApplicableSettlementInstructionDetailsBuilder prune() {
			super.prune();
			settlementDetails = settlementDetails.stream().filter(b->b!=null).<SettlementDetails.SettlementDetailsBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getSettlementDetails()!=null && getSettlementDetails().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ApplicableSettlementInstructionDetails.ApplicableSettlementInstructionDetailsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			ApplicableSettlementInstructionDetails.ApplicableSettlementInstructionDetailsBuilder o = (ApplicableSettlementInstructionDetails.ApplicableSettlementInstructionDetailsBuilder) other;
			
			merger.mergeRosetta(getSettlementDetails(), o.getSettlementDetails(), this::getOrCreateSettlementDetails);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ApplicableSettlementInstructionDetails _that = getType().cast(o);
		
			if (!ListEquals.listEquals(settlementDetails, _that.getSettlementDetails())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (settlementDetails != null ? settlementDetails.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ApplicableSettlementInstructionDetailsBuilder {" +
				"settlementDetails=" + this.settlementDetails +
			'}' + " " + super.toString();
		}
	}
}
