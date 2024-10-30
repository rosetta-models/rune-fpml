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
import com.rosetta.model.lib.records.Date;
import com.rosetta.util.ListEquals;
import fpml.confirmation.AllocationContentModel;
import fpml.confirmation.AllocationContentModel.AllocationContentModelBuilder;
import fpml.confirmation.AllocationContentModel.AllocationContentModelBuilderImpl;
import fpml.confirmation.AllocationContentModel.AllocationContentModelImpl;
import fpml.confirmation.Approvals;
import fpml.confirmation.Collateral;
import fpml.confirmation.Money;
import fpml.confirmation.RelatedParty;
import fpml.confirmation.meta.AllocationContentModelMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="AllocationContentModel", builder=AllocationContentModel.AllocationContentModelBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface AllocationContentModel extends RosettaModelObject {

	AllocationContentModelMeta metaData = new AllocationContentModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The sum that must be posted upfront to collateralize against counterparty credit risk.
	 */
	Collateral getCollateral();
	/**
	 * Special credit fee assessed to certain institutions.
	 */
	Money getCreditChargeAmount();
	/**
	 * A container for approval states in the workflow.
	 */
	Approvals getApprovals();
	/**
	 * The date of the confirmation executed between the parties and intended to govern the allocated trade between those parties.
	 */
	Date getMasterConfirmationDate();
	/**
	 * Specifies any relevant parties to the allocation which should be referenced.
	 */
	List<? extends RelatedParty> getRelatedParty();

	/*********************** Build Methods  ***********************/
	AllocationContentModel build();
	
	AllocationContentModel.AllocationContentModelBuilder toBuilder();
	
	static AllocationContentModel.AllocationContentModelBuilder builder() {
		return new AllocationContentModel.AllocationContentModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AllocationContentModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends AllocationContentModel> getType() {
		return AllocationContentModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("collateral"), processor, Collateral.class, getCollateral());
		processRosetta(path.newSubPath("creditChargeAmount"), processor, Money.class, getCreditChargeAmount());
		processRosetta(path.newSubPath("approvals"), processor, Approvals.class, getApprovals());
		processor.processBasic(path.newSubPath("masterConfirmationDate"), Date.class, getMasterConfirmationDate(), this);
		processRosetta(path.newSubPath("relatedParty"), processor, RelatedParty.class, getRelatedParty());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AllocationContentModelBuilder extends AllocationContentModel, RosettaModelObjectBuilder {
		Collateral.CollateralBuilder getOrCreateCollateral();
		Collateral.CollateralBuilder getCollateral();
		Money.MoneyBuilder getOrCreateCreditChargeAmount();
		Money.MoneyBuilder getCreditChargeAmount();
		Approvals.ApprovalsBuilder getOrCreateApprovals();
		Approvals.ApprovalsBuilder getApprovals();
		RelatedParty.RelatedPartyBuilder getOrCreateRelatedParty(int _index);
		List<? extends RelatedParty.RelatedPartyBuilder> getRelatedParty();
		AllocationContentModel.AllocationContentModelBuilder setCollateral(Collateral collateral);
		AllocationContentModel.AllocationContentModelBuilder setCreditChargeAmount(Money creditChargeAmount);
		AllocationContentModel.AllocationContentModelBuilder setApprovals(Approvals approvals);
		AllocationContentModel.AllocationContentModelBuilder setMasterConfirmationDate(Date masterConfirmationDate);
		AllocationContentModel.AllocationContentModelBuilder addRelatedParty(RelatedParty relatedParty0);
		AllocationContentModel.AllocationContentModelBuilder addRelatedParty(RelatedParty relatedParty1, int _idx);
		AllocationContentModel.AllocationContentModelBuilder addRelatedParty(List<? extends RelatedParty> relatedParty2);
		AllocationContentModel.AllocationContentModelBuilder setRelatedParty(List<? extends RelatedParty> relatedParty3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("collateral"), processor, Collateral.CollateralBuilder.class, getCollateral());
			processRosetta(path.newSubPath("creditChargeAmount"), processor, Money.MoneyBuilder.class, getCreditChargeAmount());
			processRosetta(path.newSubPath("approvals"), processor, Approvals.ApprovalsBuilder.class, getApprovals());
			processor.processBasic(path.newSubPath("masterConfirmationDate"), Date.class, getMasterConfirmationDate(), this);
			processRosetta(path.newSubPath("relatedParty"), processor, RelatedParty.RelatedPartyBuilder.class, getRelatedParty());
		}
		

		AllocationContentModel.AllocationContentModelBuilder prune();
	}

	/*********************** Immutable Implementation of AllocationContentModel  ***********************/
	class AllocationContentModelImpl implements AllocationContentModel {
		private final Collateral collateral;
		private final Money creditChargeAmount;
		private final Approvals approvals;
		private final Date masterConfirmationDate;
		private final List<? extends RelatedParty> relatedParty;
		
		protected AllocationContentModelImpl(AllocationContentModel.AllocationContentModelBuilder builder) {
			this.collateral = ofNullable(builder.getCollateral()).map(f->f.build()).orElse(null);
			this.creditChargeAmount = ofNullable(builder.getCreditChargeAmount()).map(f->f.build()).orElse(null);
			this.approvals = ofNullable(builder.getApprovals()).map(f->f.build()).orElse(null);
			this.masterConfirmationDate = builder.getMasterConfirmationDate();
			this.relatedParty = ofNullable(builder.getRelatedParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("collateral")
		public Collateral getCollateral() {
			return collateral;
		}
		
		@Override
		@RosettaAttribute("creditChargeAmount")
		public Money getCreditChargeAmount() {
			return creditChargeAmount;
		}
		
		@Override
		@RosettaAttribute("approvals")
		public Approvals getApprovals() {
			return approvals;
		}
		
		@Override
		@RosettaAttribute("masterConfirmationDate")
		public Date getMasterConfirmationDate() {
			return masterConfirmationDate;
		}
		
		@Override
		@RosettaAttribute("relatedParty")
		public List<? extends RelatedParty> getRelatedParty() {
			return relatedParty;
		}
		
		@Override
		public AllocationContentModel build() {
			return this;
		}
		
		@Override
		public AllocationContentModel.AllocationContentModelBuilder toBuilder() {
			AllocationContentModel.AllocationContentModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AllocationContentModel.AllocationContentModelBuilder builder) {
			ofNullable(getCollateral()).ifPresent(builder::setCollateral);
			ofNullable(getCreditChargeAmount()).ifPresent(builder::setCreditChargeAmount);
			ofNullable(getApprovals()).ifPresent(builder::setApprovals);
			ofNullable(getMasterConfirmationDate()).ifPresent(builder::setMasterConfirmationDate);
			ofNullable(getRelatedParty()).ifPresent(builder::setRelatedParty);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AllocationContentModel _that = getType().cast(o);
		
			if (!Objects.equals(collateral, _that.getCollateral())) return false;
			if (!Objects.equals(creditChargeAmount, _that.getCreditChargeAmount())) return false;
			if (!Objects.equals(approvals, _that.getApprovals())) return false;
			if (!Objects.equals(masterConfirmationDate, _that.getMasterConfirmationDate())) return false;
			if (!ListEquals.listEquals(relatedParty, _that.getRelatedParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (collateral != null ? collateral.hashCode() : 0);
			_result = 31 * _result + (creditChargeAmount != null ? creditChargeAmount.hashCode() : 0);
			_result = 31 * _result + (approvals != null ? approvals.hashCode() : 0);
			_result = 31 * _result + (masterConfirmationDate != null ? masterConfirmationDate.hashCode() : 0);
			_result = 31 * _result + (relatedParty != null ? relatedParty.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AllocationContentModel {" +
				"collateral=" + this.collateral + ", " +
				"creditChargeAmount=" + this.creditChargeAmount + ", " +
				"approvals=" + this.approvals + ", " +
				"masterConfirmationDate=" + this.masterConfirmationDate + ", " +
				"relatedParty=" + this.relatedParty +
			'}';
		}
	}

	/*********************** Builder Implementation of AllocationContentModel  ***********************/
	class AllocationContentModelBuilderImpl implements AllocationContentModel.AllocationContentModelBuilder {
	
		protected Collateral.CollateralBuilder collateral;
		protected Money.MoneyBuilder creditChargeAmount;
		protected Approvals.ApprovalsBuilder approvals;
		protected Date masterConfirmationDate;
		protected List<RelatedParty.RelatedPartyBuilder> relatedParty = new ArrayList<>();
	
		public AllocationContentModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("collateral")
		public Collateral.CollateralBuilder getCollateral() {
			return collateral;
		}
		
		@Override
		public Collateral.CollateralBuilder getOrCreateCollateral() {
			Collateral.CollateralBuilder result;
			if (collateral!=null) {
				result = collateral;
			}
			else {
				result = collateral = Collateral.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("creditChargeAmount")
		public Money.MoneyBuilder getCreditChargeAmount() {
			return creditChargeAmount;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreateCreditChargeAmount() {
			Money.MoneyBuilder result;
			if (creditChargeAmount!=null) {
				result = creditChargeAmount;
			}
			else {
				result = creditChargeAmount = Money.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("approvals")
		public Approvals.ApprovalsBuilder getApprovals() {
			return approvals;
		}
		
		@Override
		public Approvals.ApprovalsBuilder getOrCreateApprovals() {
			Approvals.ApprovalsBuilder result;
			if (approvals!=null) {
				result = approvals;
			}
			else {
				result = approvals = Approvals.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("masterConfirmationDate")
		public Date getMasterConfirmationDate() {
			return masterConfirmationDate;
		}
		
		@Override
		@RosettaAttribute("relatedParty")
		public List<? extends RelatedParty.RelatedPartyBuilder> getRelatedParty() {
			return relatedParty;
		}
		
		@Override
		public RelatedParty.RelatedPartyBuilder getOrCreateRelatedParty(int _index) {
		
			if (relatedParty==null) {
				this.relatedParty = new ArrayList<>();
			}
			RelatedParty.RelatedPartyBuilder result;
			return getIndex(relatedParty, _index, () -> {
						RelatedParty.RelatedPartyBuilder newRelatedParty = RelatedParty.builder();
						return newRelatedParty;
					});
		}
		
		@Override
		@RosettaAttribute("collateral")
		public AllocationContentModel.AllocationContentModelBuilder setCollateral(Collateral collateral) {
			this.collateral = collateral==null?null:collateral.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("creditChargeAmount")
		public AllocationContentModel.AllocationContentModelBuilder setCreditChargeAmount(Money creditChargeAmount) {
			this.creditChargeAmount = creditChargeAmount==null?null:creditChargeAmount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("approvals")
		public AllocationContentModel.AllocationContentModelBuilder setApprovals(Approvals approvals) {
			this.approvals = approvals==null?null:approvals.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("masterConfirmationDate")
		public AllocationContentModel.AllocationContentModelBuilder setMasterConfirmationDate(Date masterConfirmationDate) {
			this.masterConfirmationDate = masterConfirmationDate==null?null:masterConfirmationDate;
			return this;
		}
		@Override
		@RosettaAttribute("relatedParty")
		public AllocationContentModel.AllocationContentModelBuilder addRelatedParty(RelatedParty relatedParty) {
			if (relatedParty!=null) this.relatedParty.add(relatedParty.toBuilder());
			return this;
		}
		
		@Override
		public AllocationContentModel.AllocationContentModelBuilder addRelatedParty(RelatedParty relatedParty, int _idx) {
			getIndex(this.relatedParty, _idx, () -> relatedParty.toBuilder());
			return this;
		}
		@Override 
		public AllocationContentModel.AllocationContentModelBuilder addRelatedParty(List<? extends RelatedParty> relatedPartys) {
			if (relatedPartys != null) {
				for (RelatedParty toAdd : relatedPartys) {
					this.relatedParty.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public AllocationContentModel.AllocationContentModelBuilder setRelatedParty(List<? extends RelatedParty> relatedPartys) {
			if (relatedPartys == null)  {
				this.relatedParty = new ArrayList<>();
			}
			else {
				this.relatedParty = relatedPartys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public AllocationContentModel build() {
			return new AllocationContentModel.AllocationContentModelImpl(this);
		}
		
		@Override
		public AllocationContentModel.AllocationContentModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AllocationContentModel.AllocationContentModelBuilder prune() {
			if (collateral!=null && !collateral.prune().hasData()) collateral = null;
			if (creditChargeAmount!=null && !creditChargeAmount.prune().hasData()) creditChargeAmount = null;
			if (approvals!=null && !approvals.prune().hasData()) approvals = null;
			relatedParty = relatedParty.stream().filter(b->b!=null).<RelatedParty.RelatedPartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCollateral()!=null && getCollateral().hasData()) return true;
			if (getCreditChargeAmount()!=null && getCreditChargeAmount().hasData()) return true;
			if (getApprovals()!=null && getApprovals().hasData()) return true;
			if (getMasterConfirmationDate()!=null) return true;
			if (getRelatedParty()!=null && getRelatedParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AllocationContentModel.AllocationContentModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AllocationContentModel.AllocationContentModelBuilder o = (AllocationContentModel.AllocationContentModelBuilder) other;
			
			merger.mergeRosetta(getCollateral(), o.getCollateral(), this::setCollateral);
			merger.mergeRosetta(getCreditChargeAmount(), o.getCreditChargeAmount(), this::setCreditChargeAmount);
			merger.mergeRosetta(getApprovals(), o.getApprovals(), this::setApprovals);
			merger.mergeRosetta(getRelatedParty(), o.getRelatedParty(), this::getOrCreateRelatedParty);
			
			merger.mergeBasic(getMasterConfirmationDate(), o.getMasterConfirmationDate(), this::setMasterConfirmationDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AllocationContentModel _that = getType().cast(o);
		
			if (!Objects.equals(collateral, _that.getCollateral())) return false;
			if (!Objects.equals(creditChargeAmount, _that.getCreditChargeAmount())) return false;
			if (!Objects.equals(approvals, _that.getApprovals())) return false;
			if (!Objects.equals(masterConfirmationDate, _that.getMasterConfirmationDate())) return false;
			if (!ListEquals.listEquals(relatedParty, _that.getRelatedParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (collateral != null ? collateral.hashCode() : 0);
			_result = 31 * _result + (creditChargeAmount != null ? creditChargeAmount.hashCode() : 0);
			_result = 31 * _result + (approvals != null ? approvals.hashCode() : 0);
			_result = 31 * _result + (masterConfirmationDate != null ? masterConfirmationDate.hashCode() : 0);
			_result = 31 * _result + (relatedParty != null ? relatedParty.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AllocationContentModelBuilder {" +
				"collateral=" + this.collateral + ", " +
				"creditChargeAmount=" + this.creditChargeAmount + ", " +
				"approvals=" + this.approvals + ", " +
				"masterConfirmationDate=" + this.masterConfirmationDate + ", " +
				"relatedParty=" + this.relatedParty +
			'}';
		}
	}
}
