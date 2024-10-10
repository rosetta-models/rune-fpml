package fpml.confirmation;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.confirmation.CashPayable;
import fpml.confirmation.LenderAndCashDetailsModel;
import fpml.confirmation.LenderAndCashDetailsModel.LenderAndCashDetailsModelBuilder;
import fpml.confirmation.LenderAndCashDetailsModel.LenderAndCashDetailsModelBuilderImpl;
import fpml.confirmation.LenderAndCashDetailsModel.LenderAndCashDetailsModelImpl;
import fpml.confirmation.PartyReference;
import fpml.confirmation.meta.LenderAndCashDetailsModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A model that describes lender and cash flow details (relative to the lender), represented within a business event.
 * @version ${project.version}
 */
@RosettaDataType(value="LenderAndCashDetailsModel", builder=LenderAndCashDetailsModel.LenderAndCashDetailsModelBuilderImpl.class, version="${project.version}")
public interface LenderAndCashDetailsModel extends RosettaModelObject {

	LenderAndCashDetailsModelMeta metaData = new LenderAndCashDetailsModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A reference to the lender associated with a specific business event.
	 */
	PartyReference getLenderPartyReference();
	/**
	 * Defines the overall net cash payable, as well as, the breakdown of individual cashflows.
	 */
	CashPayable getCashPayable();

	/*********************** Build Methods  ***********************/
	LenderAndCashDetailsModel build();
	
	LenderAndCashDetailsModel.LenderAndCashDetailsModelBuilder toBuilder();
	
	static LenderAndCashDetailsModel.LenderAndCashDetailsModelBuilder builder() {
		return new LenderAndCashDetailsModel.LenderAndCashDetailsModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LenderAndCashDetailsModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LenderAndCashDetailsModel> getType() {
		return LenderAndCashDetailsModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("lenderPartyReference"), processor, PartyReference.class, getLenderPartyReference());
		processRosetta(path.newSubPath("cashPayable"), processor, CashPayable.class, getCashPayable());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LenderAndCashDetailsModelBuilder extends LenderAndCashDetailsModel, RosettaModelObjectBuilder {
		PartyReference.PartyReferenceBuilder getOrCreateLenderPartyReference();
		PartyReference.PartyReferenceBuilder getLenderPartyReference();
		CashPayable.CashPayableBuilder getOrCreateCashPayable();
		CashPayable.CashPayableBuilder getCashPayable();
		LenderAndCashDetailsModel.LenderAndCashDetailsModelBuilder setLenderPartyReference(PartyReference lenderPartyReference);
		LenderAndCashDetailsModel.LenderAndCashDetailsModelBuilder setCashPayable(CashPayable cashPayable);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("lenderPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getLenderPartyReference());
			processRosetta(path.newSubPath("cashPayable"), processor, CashPayable.CashPayableBuilder.class, getCashPayable());
		}
		

		LenderAndCashDetailsModel.LenderAndCashDetailsModelBuilder prune();
	}

	/*********************** Immutable Implementation of LenderAndCashDetailsModel  ***********************/
	class LenderAndCashDetailsModelImpl implements LenderAndCashDetailsModel {
		private final PartyReference lenderPartyReference;
		private final CashPayable cashPayable;
		
		protected LenderAndCashDetailsModelImpl(LenderAndCashDetailsModel.LenderAndCashDetailsModelBuilder builder) {
			this.lenderPartyReference = ofNullable(builder.getLenderPartyReference()).map(f->f.build()).orElse(null);
			this.cashPayable = ofNullable(builder.getCashPayable()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("lenderPartyReference")
		public PartyReference getLenderPartyReference() {
			return lenderPartyReference;
		}
		
		@Override
		@RosettaAttribute("cashPayable")
		public CashPayable getCashPayable() {
			return cashPayable;
		}
		
		@Override
		public LenderAndCashDetailsModel build() {
			return this;
		}
		
		@Override
		public LenderAndCashDetailsModel.LenderAndCashDetailsModelBuilder toBuilder() {
			LenderAndCashDetailsModel.LenderAndCashDetailsModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LenderAndCashDetailsModel.LenderAndCashDetailsModelBuilder builder) {
			ofNullable(getLenderPartyReference()).ifPresent(builder::setLenderPartyReference);
			ofNullable(getCashPayable()).ifPresent(builder::setCashPayable);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LenderAndCashDetailsModel _that = getType().cast(o);
		
			if (!Objects.equals(lenderPartyReference, _that.getLenderPartyReference())) return false;
			if (!Objects.equals(cashPayable, _that.getCashPayable())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (lenderPartyReference != null ? lenderPartyReference.hashCode() : 0);
			_result = 31 * _result + (cashPayable != null ? cashPayable.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LenderAndCashDetailsModel {" +
				"lenderPartyReference=" + this.lenderPartyReference + ", " +
				"cashPayable=" + this.cashPayable +
			'}';
		}
	}

	/*********************** Builder Implementation of LenderAndCashDetailsModel  ***********************/
	class LenderAndCashDetailsModelBuilderImpl implements LenderAndCashDetailsModel.LenderAndCashDetailsModelBuilder {
	
		protected PartyReference.PartyReferenceBuilder lenderPartyReference;
		protected CashPayable.CashPayableBuilder cashPayable;
	
		public LenderAndCashDetailsModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("lenderPartyReference")
		public PartyReference.PartyReferenceBuilder getLenderPartyReference() {
			return lenderPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateLenderPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (lenderPartyReference!=null) {
				result = lenderPartyReference;
			}
			else {
				result = lenderPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("cashPayable")
		public CashPayable.CashPayableBuilder getCashPayable() {
			return cashPayable;
		}
		
		@Override
		public CashPayable.CashPayableBuilder getOrCreateCashPayable() {
			CashPayable.CashPayableBuilder result;
			if (cashPayable!=null) {
				result = cashPayable;
			}
			else {
				result = cashPayable = CashPayable.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("lenderPartyReference")
		public LenderAndCashDetailsModel.LenderAndCashDetailsModelBuilder setLenderPartyReference(PartyReference lenderPartyReference) {
			this.lenderPartyReference = lenderPartyReference==null?null:lenderPartyReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("cashPayable")
		public LenderAndCashDetailsModel.LenderAndCashDetailsModelBuilder setCashPayable(CashPayable cashPayable) {
			this.cashPayable = cashPayable==null?null:cashPayable.toBuilder();
			return this;
		}
		
		@Override
		public LenderAndCashDetailsModel build() {
			return new LenderAndCashDetailsModel.LenderAndCashDetailsModelImpl(this);
		}
		
		@Override
		public LenderAndCashDetailsModel.LenderAndCashDetailsModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LenderAndCashDetailsModel.LenderAndCashDetailsModelBuilder prune() {
			if (lenderPartyReference!=null && !lenderPartyReference.prune().hasData()) lenderPartyReference = null;
			if (cashPayable!=null && !cashPayable.prune().hasData()) cashPayable = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getLenderPartyReference()!=null && getLenderPartyReference().hasData()) return true;
			if (getCashPayable()!=null && getCashPayable().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LenderAndCashDetailsModel.LenderAndCashDetailsModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LenderAndCashDetailsModel.LenderAndCashDetailsModelBuilder o = (LenderAndCashDetailsModel.LenderAndCashDetailsModelBuilder) other;
			
			merger.mergeRosetta(getLenderPartyReference(), o.getLenderPartyReference(), this::setLenderPartyReference);
			merger.mergeRosetta(getCashPayable(), o.getCashPayable(), this::setCashPayable);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LenderAndCashDetailsModel _that = getType().cast(o);
		
			if (!Objects.equals(lenderPartyReference, _that.getLenderPartyReference())) return false;
			if (!Objects.equals(cashPayable, _that.getCashPayable())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (lenderPartyReference != null ? lenderPartyReference.hashCode() : 0);
			_result = 31 * _result + (cashPayable != null ? cashPayable.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LenderAndCashDetailsModelBuilder {" +
				"lenderPartyReference=" + this.lenderPartyReference + ", " +
				"cashPayable=" + this.cashPayable +
			'}';
		}
	}
}
