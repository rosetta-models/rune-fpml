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
import fpml.confirmation.AccountReference;
import fpml.confirmation.BuyerSellerModel;
import fpml.confirmation.BuyerSellerModel.BuyerSellerModelBuilder;
import fpml.confirmation.BuyerSellerModel.BuyerSellerModelBuilderImpl;
import fpml.confirmation.BuyerSellerModel.BuyerSellerModelImpl;
import fpml.confirmation.PartyReference;
import fpml.confirmation.meta.BuyerSellerModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="BuyerSellerModel", builder=BuyerSellerModel.BuyerSellerModelBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface BuyerSellerModel extends RosettaModelObject {

	BuyerSellerModelMeta metaData = new BuyerSellerModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A reference to the party that buys this instrument, ie. pays for this instrument and receives the rights defined by it. See 2000 ISDA definitions Article 11.1 (b). In the case of FRAs this the fixed rate payer.
	 */
	PartyReference getBuyerPartyReference();
	/**
	 * A reference to the account that buys this instrument.
	 */
	AccountReference getBuyerAccountReference();
	/**
	 * A reference to the party that sells (&quot;writes&quot;) this instrument, i.e. that grants the rights defined by this instrument and in return receives a payment for it. See 2000 ISDA definitions Article 11.1 (a). In the case of FRAs this is the floating rate payer.
	 */
	PartyReference getSellerPartyReference();
	/**
	 * A reference to the account that sells this instrument.
	 */
	AccountReference getSellerAccountReference();

	/*********************** Build Methods  ***********************/
	BuyerSellerModel build();
	
	BuyerSellerModel.BuyerSellerModelBuilder toBuilder();
	
	static BuyerSellerModel.BuyerSellerModelBuilder builder() {
		return new BuyerSellerModel.BuyerSellerModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends BuyerSellerModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends BuyerSellerModel> getType() {
		return BuyerSellerModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("buyerPartyReference"), processor, PartyReference.class, getBuyerPartyReference());
		processRosetta(path.newSubPath("buyerAccountReference"), processor, AccountReference.class, getBuyerAccountReference());
		processRosetta(path.newSubPath("sellerPartyReference"), processor, PartyReference.class, getSellerPartyReference());
		processRosetta(path.newSubPath("sellerAccountReference"), processor, AccountReference.class, getSellerAccountReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface BuyerSellerModelBuilder extends BuyerSellerModel, RosettaModelObjectBuilder {
		PartyReference.PartyReferenceBuilder getOrCreateBuyerPartyReference();
		PartyReference.PartyReferenceBuilder getBuyerPartyReference();
		AccountReference.AccountReferenceBuilder getOrCreateBuyerAccountReference();
		AccountReference.AccountReferenceBuilder getBuyerAccountReference();
		PartyReference.PartyReferenceBuilder getOrCreateSellerPartyReference();
		PartyReference.PartyReferenceBuilder getSellerPartyReference();
		AccountReference.AccountReferenceBuilder getOrCreateSellerAccountReference();
		AccountReference.AccountReferenceBuilder getSellerAccountReference();
		BuyerSellerModel.BuyerSellerModelBuilder setBuyerPartyReference(PartyReference buyerPartyReference);
		BuyerSellerModel.BuyerSellerModelBuilder setBuyerAccountReference(AccountReference buyerAccountReference);
		BuyerSellerModel.BuyerSellerModelBuilder setSellerPartyReference(PartyReference sellerPartyReference);
		BuyerSellerModel.BuyerSellerModelBuilder setSellerAccountReference(AccountReference sellerAccountReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("buyerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getBuyerPartyReference());
			processRosetta(path.newSubPath("buyerAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getBuyerAccountReference());
			processRosetta(path.newSubPath("sellerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getSellerPartyReference());
			processRosetta(path.newSubPath("sellerAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getSellerAccountReference());
		}
		

		BuyerSellerModel.BuyerSellerModelBuilder prune();
	}

	/*********************** Immutable Implementation of BuyerSellerModel  ***********************/
	class BuyerSellerModelImpl implements BuyerSellerModel {
		private final PartyReference buyerPartyReference;
		private final AccountReference buyerAccountReference;
		private final PartyReference sellerPartyReference;
		private final AccountReference sellerAccountReference;
		
		protected BuyerSellerModelImpl(BuyerSellerModel.BuyerSellerModelBuilder builder) {
			this.buyerPartyReference = ofNullable(builder.getBuyerPartyReference()).map(f->f.build()).orElse(null);
			this.buyerAccountReference = ofNullable(builder.getBuyerAccountReference()).map(f->f.build()).orElse(null);
			this.sellerPartyReference = ofNullable(builder.getSellerPartyReference()).map(f->f.build()).orElse(null);
			this.sellerAccountReference = ofNullable(builder.getSellerAccountReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("buyerPartyReference")
		public PartyReference getBuyerPartyReference() {
			return buyerPartyReference;
		}
		
		@Override
		@RosettaAttribute("buyerAccountReference")
		public AccountReference getBuyerAccountReference() {
			return buyerAccountReference;
		}
		
		@Override
		@RosettaAttribute("sellerPartyReference")
		public PartyReference getSellerPartyReference() {
			return sellerPartyReference;
		}
		
		@Override
		@RosettaAttribute("sellerAccountReference")
		public AccountReference getSellerAccountReference() {
			return sellerAccountReference;
		}
		
		@Override
		public BuyerSellerModel build() {
			return this;
		}
		
		@Override
		public BuyerSellerModel.BuyerSellerModelBuilder toBuilder() {
			BuyerSellerModel.BuyerSellerModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BuyerSellerModel.BuyerSellerModelBuilder builder) {
			ofNullable(getBuyerPartyReference()).ifPresent(builder::setBuyerPartyReference);
			ofNullable(getBuyerAccountReference()).ifPresent(builder::setBuyerAccountReference);
			ofNullable(getSellerPartyReference()).ifPresent(builder::setSellerPartyReference);
			ofNullable(getSellerAccountReference()).ifPresent(builder::setSellerAccountReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BuyerSellerModel _that = getType().cast(o);
		
			if (!Objects.equals(buyerPartyReference, _that.getBuyerPartyReference())) return false;
			if (!Objects.equals(buyerAccountReference, _that.getBuyerAccountReference())) return false;
			if (!Objects.equals(sellerPartyReference, _that.getSellerPartyReference())) return false;
			if (!Objects.equals(sellerAccountReference, _that.getSellerAccountReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (buyerPartyReference != null ? buyerPartyReference.hashCode() : 0);
			_result = 31 * _result + (buyerAccountReference != null ? buyerAccountReference.hashCode() : 0);
			_result = 31 * _result + (sellerPartyReference != null ? sellerPartyReference.hashCode() : 0);
			_result = 31 * _result + (sellerAccountReference != null ? sellerAccountReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BuyerSellerModel {" +
				"buyerPartyReference=" + this.buyerPartyReference + ", " +
				"buyerAccountReference=" + this.buyerAccountReference + ", " +
				"sellerPartyReference=" + this.sellerPartyReference + ", " +
				"sellerAccountReference=" + this.sellerAccountReference +
			'}';
		}
	}

	/*********************** Builder Implementation of BuyerSellerModel  ***********************/
	class BuyerSellerModelBuilderImpl implements BuyerSellerModel.BuyerSellerModelBuilder {
	
		protected PartyReference.PartyReferenceBuilder buyerPartyReference;
		protected AccountReference.AccountReferenceBuilder buyerAccountReference;
		protected PartyReference.PartyReferenceBuilder sellerPartyReference;
		protected AccountReference.AccountReferenceBuilder sellerAccountReference;
	
		public BuyerSellerModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("buyerPartyReference")
		public PartyReference.PartyReferenceBuilder getBuyerPartyReference() {
			return buyerPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateBuyerPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (buyerPartyReference!=null) {
				result = buyerPartyReference;
			}
			else {
				result = buyerPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("buyerAccountReference")
		public AccountReference.AccountReferenceBuilder getBuyerAccountReference() {
			return buyerAccountReference;
		}
		
		@Override
		public AccountReference.AccountReferenceBuilder getOrCreateBuyerAccountReference() {
			AccountReference.AccountReferenceBuilder result;
			if (buyerAccountReference!=null) {
				result = buyerAccountReference;
			}
			else {
				result = buyerAccountReference = AccountReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("sellerPartyReference")
		public PartyReference.PartyReferenceBuilder getSellerPartyReference() {
			return sellerPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateSellerPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (sellerPartyReference!=null) {
				result = sellerPartyReference;
			}
			else {
				result = sellerPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("sellerAccountReference")
		public AccountReference.AccountReferenceBuilder getSellerAccountReference() {
			return sellerAccountReference;
		}
		
		@Override
		public AccountReference.AccountReferenceBuilder getOrCreateSellerAccountReference() {
			AccountReference.AccountReferenceBuilder result;
			if (sellerAccountReference!=null) {
				result = sellerAccountReference;
			}
			else {
				result = sellerAccountReference = AccountReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("buyerPartyReference")
		public BuyerSellerModel.BuyerSellerModelBuilder setBuyerPartyReference(PartyReference buyerPartyReference) {
			this.buyerPartyReference = buyerPartyReference==null?null:buyerPartyReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("buyerAccountReference")
		public BuyerSellerModel.BuyerSellerModelBuilder setBuyerAccountReference(AccountReference buyerAccountReference) {
			this.buyerAccountReference = buyerAccountReference==null?null:buyerAccountReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("sellerPartyReference")
		public BuyerSellerModel.BuyerSellerModelBuilder setSellerPartyReference(PartyReference sellerPartyReference) {
			this.sellerPartyReference = sellerPartyReference==null?null:sellerPartyReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("sellerAccountReference")
		public BuyerSellerModel.BuyerSellerModelBuilder setSellerAccountReference(AccountReference sellerAccountReference) {
			this.sellerAccountReference = sellerAccountReference==null?null:sellerAccountReference.toBuilder();
			return this;
		}
		
		@Override
		public BuyerSellerModel build() {
			return new BuyerSellerModel.BuyerSellerModelImpl(this);
		}
		
		@Override
		public BuyerSellerModel.BuyerSellerModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BuyerSellerModel.BuyerSellerModelBuilder prune() {
			if (buyerPartyReference!=null && !buyerPartyReference.prune().hasData()) buyerPartyReference = null;
			if (buyerAccountReference!=null && !buyerAccountReference.prune().hasData()) buyerAccountReference = null;
			if (sellerPartyReference!=null && !sellerPartyReference.prune().hasData()) sellerPartyReference = null;
			if (sellerAccountReference!=null && !sellerAccountReference.prune().hasData()) sellerAccountReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBuyerPartyReference()!=null && getBuyerPartyReference().hasData()) return true;
			if (getBuyerAccountReference()!=null && getBuyerAccountReference().hasData()) return true;
			if (getSellerPartyReference()!=null && getSellerPartyReference().hasData()) return true;
			if (getSellerAccountReference()!=null && getSellerAccountReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BuyerSellerModel.BuyerSellerModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			BuyerSellerModel.BuyerSellerModelBuilder o = (BuyerSellerModel.BuyerSellerModelBuilder) other;
			
			merger.mergeRosetta(getBuyerPartyReference(), o.getBuyerPartyReference(), this::setBuyerPartyReference);
			merger.mergeRosetta(getBuyerAccountReference(), o.getBuyerAccountReference(), this::setBuyerAccountReference);
			merger.mergeRosetta(getSellerPartyReference(), o.getSellerPartyReference(), this::setSellerPartyReference);
			merger.mergeRosetta(getSellerAccountReference(), o.getSellerAccountReference(), this::setSellerAccountReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BuyerSellerModel _that = getType().cast(o);
		
			if (!Objects.equals(buyerPartyReference, _that.getBuyerPartyReference())) return false;
			if (!Objects.equals(buyerAccountReference, _that.getBuyerAccountReference())) return false;
			if (!Objects.equals(sellerPartyReference, _that.getSellerPartyReference())) return false;
			if (!Objects.equals(sellerAccountReference, _that.getSellerAccountReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (buyerPartyReference != null ? buyerPartyReference.hashCode() : 0);
			_result = 31 * _result + (buyerAccountReference != null ? buyerAccountReference.hashCode() : 0);
			_result = 31 * _result + (sellerPartyReference != null ? sellerPartyReference.hashCode() : 0);
			_result = 31 * _result + (sellerAccountReference != null ? sellerAccountReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BuyerSellerModelBuilder {" +
				"buyerPartyReference=" + this.buyerPartyReference + ", " +
				"buyerAccountReference=" + this.buyerAccountReference + ", " +
				"sellerPartyReference=" + this.sellerPartyReference + ", " +
				"sellerAccountReference=" + this.sellerAccountReference +
			'}';
		}
	}
}
