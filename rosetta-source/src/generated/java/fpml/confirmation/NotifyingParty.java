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
import fpml.confirmation.NotifyingParty;
import fpml.confirmation.NotifyingParty.NotifyingPartyBuilder;
import fpml.confirmation.NotifyingParty.NotifyingPartyBuilderImpl;
import fpml.confirmation.NotifyingParty.NotifyingPartyImpl;
import fpml.confirmation.PartyReference;
import fpml.confirmation.meta.NotifyingPartyMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="NotifyingParty", builder=NotifyingParty.NotifyingPartyBuilderImpl.class, version="${project.version}")
public interface NotifyingParty extends RosettaModelObject {

	NotifyingPartyMeta metaData = new NotifyingPartyMeta();

	/*********************** Getter Methods  ***********************/
	PartyReference getBuyerPartyReference();
	PartyReference getSellerPartyReference();

	/*********************** Build Methods  ***********************/
	NotifyingParty build();
	
	NotifyingParty.NotifyingPartyBuilder toBuilder();
	
	static NotifyingParty.NotifyingPartyBuilder builder() {
		return new NotifyingParty.NotifyingPartyBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NotifyingParty> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends NotifyingParty> getType() {
		return NotifyingParty.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("buyerPartyReference"), processor, PartyReference.class, getBuyerPartyReference());
		processRosetta(path.newSubPath("sellerPartyReference"), processor, PartyReference.class, getSellerPartyReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface NotifyingPartyBuilder extends NotifyingParty, RosettaModelObjectBuilder {
		PartyReference.PartyReferenceBuilder getOrCreateBuyerPartyReference();
		PartyReference.PartyReferenceBuilder getBuyerPartyReference();
		PartyReference.PartyReferenceBuilder getOrCreateSellerPartyReference();
		PartyReference.PartyReferenceBuilder getSellerPartyReference();
		NotifyingParty.NotifyingPartyBuilder setBuyerPartyReference(PartyReference buyerPartyReference);
		NotifyingParty.NotifyingPartyBuilder setSellerPartyReference(PartyReference sellerPartyReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("buyerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getBuyerPartyReference());
			processRosetta(path.newSubPath("sellerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getSellerPartyReference());
		}
		

		NotifyingParty.NotifyingPartyBuilder prune();
	}

	/*********************** Immutable Implementation of NotifyingParty  ***********************/
	class NotifyingPartyImpl implements NotifyingParty {
		private final PartyReference buyerPartyReference;
		private final PartyReference sellerPartyReference;
		
		protected NotifyingPartyImpl(NotifyingParty.NotifyingPartyBuilder builder) {
			this.buyerPartyReference = ofNullable(builder.getBuyerPartyReference()).map(f->f.build()).orElse(null);
			this.sellerPartyReference = ofNullable(builder.getSellerPartyReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("buyerPartyReference")
		public PartyReference getBuyerPartyReference() {
			return buyerPartyReference;
		}
		
		@Override
		@RosettaAttribute("sellerPartyReference")
		public PartyReference getSellerPartyReference() {
			return sellerPartyReference;
		}
		
		@Override
		public NotifyingParty build() {
			return this;
		}
		
		@Override
		public NotifyingParty.NotifyingPartyBuilder toBuilder() {
			NotifyingParty.NotifyingPartyBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NotifyingParty.NotifyingPartyBuilder builder) {
			ofNullable(getBuyerPartyReference()).ifPresent(builder::setBuyerPartyReference);
			ofNullable(getSellerPartyReference()).ifPresent(builder::setSellerPartyReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NotifyingParty _that = getType().cast(o);
		
			if (!Objects.equals(buyerPartyReference, _that.getBuyerPartyReference())) return false;
			if (!Objects.equals(sellerPartyReference, _that.getSellerPartyReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (buyerPartyReference != null ? buyerPartyReference.hashCode() : 0);
			_result = 31 * _result + (sellerPartyReference != null ? sellerPartyReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NotifyingParty {" +
				"buyerPartyReference=" + this.buyerPartyReference + ", " +
				"sellerPartyReference=" + this.sellerPartyReference +
			'}';
		}
	}

	/*********************** Builder Implementation of NotifyingParty  ***********************/
	class NotifyingPartyBuilderImpl implements NotifyingParty.NotifyingPartyBuilder {
	
		protected PartyReference.PartyReferenceBuilder buyerPartyReference;
		protected PartyReference.PartyReferenceBuilder sellerPartyReference;
	
		public NotifyingPartyBuilderImpl() {
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
		@RosettaAttribute("buyerPartyReference")
		public NotifyingParty.NotifyingPartyBuilder setBuyerPartyReference(PartyReference buyerPartyReference) {
			this.buyerPartyReference = buyerPartyReference==null?null:buyerPartyReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("sellerPartyReference")
		public NotifyingParty.NotifyingPartyBuilder setSellerPartyReference(PartyReference sellerPartyReference) {
			this.sellerPartyReference = sellerPartyReference==null?null:sellerPartyReference.toBuilder();
			return this;
		}
		
		@Override
		public NotifyingParty build() {
			return new NotifyingParty.NotifyingPartyImpl(this);
		}
		
		@Override
		public NotifyingParty.NotifyingPartyBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NotifyingParty.NotifyingPartyBuilder prune() {
			if (buyerPartyReference!=null && !buyerPartyReference.prune().hasData()) buyerPartyReference = null;
			if (sellerPartyReference!=null && !sellerPartyReference.prune().hasData()) sellerPartyReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBuyerPartyReference()!=null && getBuyerPartyReference().hasData()) return true;
			if (getSellerPartyReference()!=null && getSellerPartyReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NotifyingParty.NotifyingPartyBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			NotifyingParty.NotifyingPartyBuilder o = (NotifyingParty.NotifyingPartyBuilder) other;
			
			merger.mergeRosetta(getBuyerPartyReference(), o.getBuyerPartyReference(), this::setBuyerPartyReference);
			merger.mergeRosetta(getSellerPartyReference(), o.getSellerPartyReference(), this::setSellerPartyReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NotifyingParty _that = getType().cast(o);
		
			if (!Objects.equals(buyerPartyReference, _that.getBuyerPartyReference())) return false;
			if (!Objects.equals(sellerPartyReference, _that.getSellerPartyReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (buyerPartyReference != null ? buyerPartyReference.hashCode() : 0);
			_result = 31 * _result + (sellerPartyReference != null ? sellerPartyReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NotifyingPartyBuilder {" +
				"buyerPartyReference=" + this.buyerPartyReference + ", " +
				"sellerPartyReference=" + this.sellerPartyReference +
			'}';
		}
	}
}
