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
import fpml.confirmation.LoanAllocationIdentifier;
import fpml.confirmation.LoanTradeReference;
import fpml.confirmation.OverrideIdentifier;
import fpml.confirmation.SettlementDetails;
import fpml.confirmation.TradingInstructionOverride;
import fpml.confirmation.TradingInstructionOverride.TradingInstructionOverrideBuilder;
import fpml.confirmation.TradingInstructionOverride.TradingInstructionOverrideBuilderImpl;
import fpml.confirmation.TradingInstructionOverride.TradingInstructionOverrideImpl;
import fpml.confirmation.meta.TradingInstructionOverrideMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A structure that identifies settlement instructions to override default settlement instructions, for a particular trade/allocation.
 * @version ${project.version}
 */
@RosettaDataType(value="TradingInstructionOverride", builder=TradingInstructionOverride.TradingInstructionOverrideBuilderImpl.class, version="${project.version}")
public interface TradingInstructionOverride extends RosettaModelObject {

	TradingInstructionOverrideMeta metaData = new TradingInstructionOverrideMeta();

	/*********************** Getter Methods  ***********************/
	OverrideIdentifier getOverrideIdentifier();
	/**
	 * The allocation for which the settlement instructions should be applied.
	 */
	LoanAllocationIdentifier getAllocationIdentifier();
	/**
	 * Reference to the original loan trade.
	 */
	LoanTradeReference getLoanTradeReference();
	/**
	 * Settlement account details to describe the acount to which cash should be sent, for payments received by the party sending the Lender Event Settlement Notification.
	 */
	List<? extends SettlementDetails> getSettlementDetails();

	/*********************** Build Methods  ***********************/
	TradingInstructionOverride build();
	
	TradingInstructionOverride.TradingInstructionOverrideBuilder toBuilder();
	
	static TradingInstructionOverride.TradingInstructionOverrideBuilder builder() {
		return new TradingInstructionOverride.TradingInstructionOverrideBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradingInstructionOverride> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends TradingInstructionOverride> getType() {
		return TradingInstructionOverride.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("overrideIdentifier"), processor, OverrideIdentifier.class, getOverrideIdentifier());
		processRosetta(path.newSubPath("allocationIdentifier"), processor, LoanAllocationIdentifier.class, getAllocationIdentifier());
		processRosetta(path.newSubPath("loanTradeReference"), processor, LoanTradeReference.class, getLoanTradeReference());
		processRosetta(path.newSubPath("settlementDetails"), processor, SettlementDetails.class, getSettlementDetails());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradingInstructionOverrideBuilder extends TradingInstructionOverride, RosettaModelObjectBuilder {
		OverrideIdentifier.OverrideIdentifierBuilder getOrCreateOverrideIdentifier();
		OverrideIdentifier.OverrideIdentifierBuilder getOverrideIdentifier();
		LoanAllocationIdentifier.LoanAllocationIdentifierBuilder getOrCreateAllocationIdentifier();
		LoanAllocationIdentifier.LoanAllocationIdentifierBuilder getAllocationIdentifier();
		LoanTradeReference.LoanTradeReferenceBuilder getOrCreateLoanTradeReference();
		LoanTradeReference.LoanTradeReferenceBuilder getLoanTradeReference();
		SettlementDetails.SettlementDetailsBuilder getOrCreateSettlementDetails(int _index);
		List<? extends SettlementDetails.SettlementDetailsBuilder> getSettlementDetails();
		TradingInstructionOverride.TradingInstructionOverrideBuilder setOverrideIdentifier(OverrideIdentifier overrideIdentifier);
		TradingInstructionOverride.TradingInstructionOverrideBuilder setAllocationIdentifier(LoanAllocationIdentifier allocationIdentifier);
		TradingInstructionOverride.TradingInstructionOverrideBuilder setLoanTradeReference(LoanTradeReference loanTradeReference);
		TradingInstructionOverride.TradingInstructionOverrideBuilder addSettlementDetails(SettlementDetails settlementDetails0);
		TradingInstructionOverride.TradingInstructionOverrideBuilder addSettlementDetails(SettlementDetails settlementDetails1, int _idx);
		TradingInstructionOverride.TradingInstructionOverrideBuilder addSettlementDetails(List<? extends SettlementDetails> settlementDetails2);
		TradingInstructionOverride.TradingInstructionOverrideBuilder setSettlementDetails(List<? extends SettlementDetails> settlementDetails3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("overrideIdentifier"), processor, OverrideIdentifier.OverrideIdentifierBuilder.class, getOverrideIdentifier());
			processRosetta(path.newSubPath("allocationIdentifier"), processor, LoanAllocationIdentifier.LoanAllocationIdentifierBuilder.class, getAllocationIdentifier());
			processRosetta(path.newSubPath("loanTradeReference"), processor, LoanTradeReference.LoanTradeReferenceBuilder.class, getLoanTradeReference());
			processRosetta(path.newSubPath("settlementDetails"), processor, SettlementDetails.SettlementDetailsBuilder.class, getSettlementDetails());
		}
		

		TradingInstructionOverride.TradingInstructionOverrideBuilder prune();
	}

	/*********************** Immutable Implementation of TradingInstructionOverride  ***********************/
	class TradingInstructionOverrideImpl implements TradingInstructionOverride {
		private final OverrideIdentifier overrideIdentifier;
		private final LoanAllocationIdentifier allocationIdentifier;
		private final LoanTradeReference loanTradeReference;
		private final List<? extends SettlementDetails> settlementDetails;
		
		protected TradingInstructionOverrideImpl(TradingInstructionOverride.TradingInstructionOverrideBuilder builder) {
			this.overrideIdentifier = ofNullable(builder.getOverrideIdentifier()).map(f->f.build()).orElse(null);
			this.allocationIdentifier = ofNullable(builder.getAllocationIdentifier()).map(f->f.build()).orElse(null);
			this.loanTradeReference = ofNullable(builder.getLoanTradeReference()).map(f->f.build()).orElse(null);
			this.settlementDetails = ofNullable(builder.getSettlementDetails()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("overrideIdentifier")
		public OverrideIdentifier getOverrideIdentifier() {
			return overrideIdentifier;
		}
		
		@Override
		@RosettaAttribute("allocationIdentifier")
		public LoanAllocationIdentifier getAllocationIdentifier() {
			return allocationIdentifier;
		}
		
		@Override
		@RosettaAttribute("loanTradeReference")
		public LoanTradeReference getLoanTradeReference() {
			return loanTradeReference;
		}
		
		@Override
		@RosettaAttribute("settlementDetails")
		public List<? extends SettlementDetails> getSettlementDetails() {
			return settlementDetails;
		}
		
		@Override
		public TradingInstructionOverride build() {
			return this;
		}
		
		@Override
		public TradingInstructionOverride.TradingInstructionOverrideBuilder toBuilder() {
			TradingInstructionOverride.TradingInstructionOverrideBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradingInstructionOverride.TradingInstructionOverrideBuilder builder) {
			ofNullable(getOverrideIdentifier()).ifPresent(builder::setOverrideIdentifier);
			ofNullable(getAllocationIdentifier()).ifPresent(builder::setAllocationIdentifier);
			ofNullable(getLoanTradeReference()).ifPresent(builder::setLoanTradeReference);
			ofNullable(getSettlementDetails()).ifPresent(builder::setSettlementDetails);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradingInstructionOverride _that = getType().cast(o);
		
			if (!Objects.equals(overrideIdentifier, _that.getOverrideIdentifier())) return false;
			if (!Objects.equals(allocationIdentifier, _that.getAllocationIdentifier())) return false;
			if (!Objects.equals(loanTradeReference, _that.getLoanTradeReference())) return false;
			if (!ListEquals.listEquals(settlementDetails, _that.getSettlementDetails())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (overrideIdentifier != null ? overrideIdentifier.hashCode() : 0);
			_result = 31 * _result + (allocationIdentifier != null ? allocationIdentifier.hashCode() : 0);
			_result = 31 * _result + (loanTradeReference != null ? loanTradeReference.hashCode() : 0);
			_result = 31 * _result + (settlementDetails != null ? settlementDetails.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradingInstructionOverride {" +
				"overrideIdentifier=" + this.overrideIdentifier + ", " +
				"allocationIdentifier=" + this.allocationIdentifier + ", " +
				"loanTradeReference=" + this.loanTradeReference + ", " +
				"settlementDetails=" + this.settlementDetails +
			'}';
		}
	}

	/*********************** Builder Implementation of TradingInstructionOverride  ***********************/
	class TradingInstructionOverrideBuilderImpl implements TradingInstructionOverride.TradingInstructionOverrideBuilder {
	
		protected OverrideIdentifier.OverrideIdentifierBuilder overrideIdentifier;
		protected LoanAllocationIdentifier.LoanAllocationIdentifierBuilder allocationIdentifier;
		protected LoanTradeReference.LoanTradeReferenceBuilder loanTradeReference;
		protected List<SettlementDetails.SettlementDetailsBuilder> settlementDetails = new ArrayList<>();
	
		public TradingInstructionOverrideBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("overrideIdentifier")
		public OverrideIdentifier.OverrideIdentifierBuilder getOverrideIdentifier() {
			return overrideIdentifier;
		}
		
		@Override
		public OverrideIdentifier.OverrideIdentifierBuilder getOrCreateOverrideIdentifier() {
			OverrideIdentifier.OverrideIdentifierBuilder result;
			if (overrideIdentifier!=null) {
				result = overrideIdentifier;
			}
			else {
				result = overrideIdentifier = OverrideIdentifier.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("allocationIdentifier")
		public LoanAllocationIdentifier.LoanAllocationIdentifierBuilder getAllocationIdentifier() {
			return allocationIdentifier;
		}
		
		@Override
		public LoanAllocationIdentifier.LoanAllocationIdentifierBuilder getOrCreateAllocationIdentifier() {
			LoanAllocationIdentifier.LoanAllocationIdentifierBuilder result;
			if (allocationIdentifier!=null) {
				result = allocationIdentifier;
			}
			else {
				result = allocationIdentifier = LoanAllocationIdentifier.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("loanTradeReference")
		public LoanTradeReference.LoanTradeReferenceBuilder getLoanTradeReference() {
			return loanTradeReference;
		}
		
		@Override
		public LoanTradeReference.LoanTradeReferenceBuilder getOrCreateLoanTradeReference() {
			LoanTradeReference.LoanTradeReferenceBuilder result;
			if (loanTradeReference!=null) {
				result = loanTradeReference;
			}
			else {
				result = loanTradeReference = LoanTradeReference.builder();
			}
			
			return result;
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
		@RosettaAttribute("overrideIdentifier")
		public TradingInstructionOverride.TradingInstructionOverrideBuilder setOverrideIdentifier(OverrideIdentifier overrideIdentifier) {
			this.overrideIdentifier = overrideIdentifier==null?null:overrideIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("allocationIdentifier")
		public TradingInstructionOverride.TradingInstructionOverrideBuilder setAllocationIdentifier(LoanAllocationIdentifier allocationIdentifier) {
			this.allocationIdentifier = allocationIdentifier==null?null:allocationIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("loanTradeReference")
		public TradingInstructionOverride.TradingInstructionOverrideBuilder setLoanTradeReference(LoanTradeReference loanTradeReference) {
			this.loanTradeReference = loanTradeReference==null?null:loanTradeReference.toBuilder();
			return this;
		}
		@Override
		public TradingInstructionOverride.TradingInstructionOverrideBuilder addSettlementDetails(SettlementDetails settlementDetails) {
			if (settlementDetails!=null) this.settlementDetails.add(settlementDetails.toBuilder());
			return this;
		}
		
		@Override
		public TradingInstructionOverride.TradingInstructionOverrideBuilder addSettlementDetails(SettlementDetails settlementDetails, int _idx) {
			getIndex(this.settlementDetails, _idx, () -> settlementDetails.toBuilder());
			return this;
		}
		@Override 
		public TradingInstructionOverride.TradingInstructionOverrideBuilder addSettlementDetails(List<? extends SettlementDetails> settlementDetailss) {
			if (settlementDetailss != null) {
				for (SettlementDetails toAdd : settlementDetailss) {
					this.settlementDetails.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("settlementDetails")
		public TradingInstructionOverride.TradingInstructionOverrideBuilder setSettlementDetails(List<? extends SettlementDetails> settlementDetailss) {
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
		public TradingInstructionOverride build() {
			return new TradingInstructionOverride.TradingInstructionOverrideImpl(this);
		}
		
		@Override
		public TradingInstructionOverride.TradingInstructionOverrideBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradingInstructionOverride.TradingInstructionOverrideBuilder prune() {
			if (overrideIdentifier!=null && !overrideIdentifier.prune().hasData()) overrideIdentifier = null;
			if (allocationIdentifier!=null && !allocationIdentifier.prune().hasData()) allocationIdentifier = null;
			if (loanTradeReference!=null && !loanTradeReference.prune().hasData()) loanTradeReference = null;
			settlementDetails = settlementDetails.stream().filter(b->b!=null).<SettlementDetails.SettlementDetailsBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getOverrideIdentifier()!=null && getOverrideIdentifier().hasData()) return true;
			if (getAllocationIdentifier()!=null && getAllocationIdentifier().hasData()) return true;
			if (getLoanTradeReference()!=null && getLoanTradeReference().hasData()) return true;
			if (getSettlementDetails()!=null && getSettlementDetails().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradingInstructionOverride.TradingInstructionOverrideBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradingInstructionOverride.TradingInstructionOverrideBuilder o = (TradingInstructionOverride.TradingInstructionOverrideBuilder) other;
			
			merger.mergeRosetta(getOverrideIdentifier(), o.getOverrideIdentifier(), this::setOverrideIdentifier);
			merger.mergeRosetta(getAllocationIdentifier(), o.getAllocationIdentifier(), this::setAllocationIdentifier);
			merger.mergeRosetta(getLoanTradeReference(), o.getLoanTradeReference(), this::setLoanTradeReference);
			merger.mergeRosetta(getSettlementDetails(), o.getSettlementDetails(), this::getOrCreateSettlementDetails);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradingInstructionOverride _that = getType().cast(o);
		
			if (!Objects.equals(overrideIdentifier, _that.getOverrideIdentifier())) return false;
			if (!Objects.equals(allocationIdentifier, _that.getAllocationIdentifier())) return false;
			if (!Objects.equals(loanTradeReference, _that.getLoanTradeReference())) return false;
			if (!ListEquals.listEquals(settlementDetails, _that.getSettlementDetails())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (overrideIdentifier != null ? overrideIdentifier.hashCode() : 0);
			_result = 31 * _result + (allocationIdentifier != null ? allocationIdentifier.hashCode() : 0);
			_result = 31 * _result + (loanTradeReference != null ? loanTradeReference.hashCode() : 0);
			_result = 31 * _result + (settlementDetails != null ? settlementDetails.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradingInstructionOverrideBuilder {" +
				"overrideIdentifier=" + this.overrideIdentifier + ", " +
				"allocationIdentifier=" + this.allocationIdentifier + ", " +
				"loanTradeReference=" + this.loanTradeReference + ", " +
				"settlementDetails=" + this.settlementDetails +
			'}';
		}
	}
}
