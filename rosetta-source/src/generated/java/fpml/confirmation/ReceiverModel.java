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
import fpml.confirmation.PartyReference;
import fpml.confirmation.ReceiverModel;
import fpml.confirmation.ReceiverModel.ReceiverModelBuilder;
import fpml.confirmation.ReceiverModel.ReceiverModelBuilderImpl;
import fpml.confirmation.ReceiverModel.ReceiverModelImpl;
import fpml.confirmation.meta.ReceiverModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="ReceiverModel", builder=ReceiverModel.ReceiverModelBuilderImpl.class, version="${project.version}")
public interface ReceiverModel extends RosettaModelObject {

	ReceiverModelMeta metaData = new ReceiverModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A reference to the party that receives the payments corresponding to this structure.
	 */
	PartyReference getReceiverPartyReference();
	/**
	 * A reference to the account that receives the payments corresponding to this structure.
	 */
	AccountReference getReceiverAccountReference();

	/*********************** Build Methods  ***********************/
	ReceiverModel build();
	
	ReceiverModel.ReceiverModelBuilder toBuilder();
	
	static ReceiverModel.ReceiverModelBuilder builder() {
		return new ReceiverModel.ReceiverModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ReceiverModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ReceiverModel> getType() {
		return ReceiverModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("receiverPartyReference"), processor, PartyReference.class, getReceiverPartyReference());
		processRosetta(path.newSubPath("receiverAccountReference"), processor, AccountReference.class, getReceiverAccountReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ReceiverModelBuilder extends ReceiverModel, RosettaModelObjectBuilder {
		PartyReference.PartyReferenceBuilder getOrCreateReceiverPartyReference();
		PartyReference.PartyReferenceBuilder getReceiverPartyReference();
		AccountReference.AccountReferenceBuilder getOrCreateReceiverAccountReference();
		AccountReference.AccountReferenceBuilder getReceiverAccountReference();
		ReceiverModel.ReceiverModelBuilder setReceiverPartyReference(PartyReference receiverPartyReference);
		ReceiverModel.ReceiverModelBuilder setReceiverAccountReference(AccountReference receiverAccountReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("receiverPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getReceiverPartyReference());
			processRosetta(path.newSubPath("receiverAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getReceiverAccountReference());
		}
		

		ReceiverModel.ReceiverModelBuilder prune();
	}

	/*********************** Immutable Implementation of ReceiverModel  ***********************/
	class ReceiverModelImpl implements ReceiverModel {
		private final PartyReference receiverPartyReference;
		private final AccountReference receiverAccountReference;
		
		protected ReceiverModelImpl(ReceiverModel.ReceiverModelBuilder builder) {
			this.receiverPartyReference = ofNullable(builder.getReceiverPartyReference()).map(f->f.build()).orElse(null);
			this.receiverAccountReference = ofNullable(builder.getReceiverAccountReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("receiverPartyReference")
		public PartyReference getReceiverPartyReference() {
			return receiverPartyReference;
		}
		
		@Override
		@RosettaAttribute("receiverAccountReference")
		public AccountReference getReceiverAccountReference() {
			return receiverAccountReference;
		}
		
		@Override
		public ReceiverModel build() {
			return this;
		}
		
		@Override
		public ReceiverModel.ReceiverModelBuilder toBuilder() {
			ReceiverModel.ReceiverModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReceiverModel.ReceiverModelBuilder builder) {
			ofNullable(getReceiverPartyReference()).ifPresent(builder::setReceiverPartyReference);
			ofNullable(getReceiverAccountReference()).ifPresent(builder::setReceiverAccountReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReceiverModel _that = getType().cast(o);
		
			if (!Objects.equals(receiverPartyReference, _that.getReceiverPartyReference())) return false;
			if (!Objects.equals(receiverAccountReference, _that.getReceiverAccountReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (receiverPartyReference != null ? receiverPartyReference.hashCode() : 0);
			_result = 31 * _result + (receiverAccountReference != null ? receiverAccountReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReceiverModel {" +
				"receiverPartyReference=" + this.receiverPartyReference + ", " +
				"receiverAccountReference=" + this.receiverAccountReference +
			'}';
		}
	}

	/*********************** Builder Implementation of ReceiverModel  ***********************/
	class ReceiverModelBuilderImpl implements ReceiverModel.ReceiverModelBuilder {
	
		protected PartyReference.PartyReferenceBuilder receiverPartyReference;
		protected AccountReference.AccountReferenceBuilder receiverAccountReference;
	
		public ReceiverModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("receiverPartyReference")
		public PartyReference.PartyReferenceBuilder getReceiverPartyReference() {
			return receiverPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateReceiverPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (receiverPartyReference!=null) {
				result = receiverPartyReference;
			}
			else {
				result = receiverPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("receiverAccountReference")
		public AccountReference.AccountReferenceBuilder getReceiverAccountReference() {
			return receiverAccountReference;
		}
		
		@Override
		public AccountReference.AccountReferenceBuilder getOrCreateReceiverAccountReference() {
			AccountReference.AccountReferenceBuilder result;
			if (receiverAccountReference!=null) {
				result = receiverAccountReference;
			}
			else {
				result = receiverAccountReference = AccountReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("receiverPartyReference")
		public ReceiverModel.ReceiverModelBuilder setReceiverPartyReference(PartyReference receiverPartyReference) {
			this.receiverPartyReference = receiverPartyReference==null?null:receiverPartyReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("receiverAccountReference")
		public ReceiverModel.ReceiverModelBuilder setReceiverAccountReference(AccountReference receiverAccountReference) {
			this.receiverAccountReference = receiverAccountReference==null?null:receiverAccountReference.toBuilder();
			return this;
		}
		
		@Override
		public ReceiverModel build() {
			return new ReceiverModel.ReceiverModelImpl(this);
		}
		
		@Override
		public ReceiverModel.ReceiverModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReceiverModel.ReceiverModelBuilder prune() {
			if (receiverPartyReference!=null && !receiverPartyReference.prune().hasData()) receiverPartyReference = null;
			if (receiverAccountReference!=null && !receiverAccountReference.prune().hasData()) receiverAccountReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getReceiverPartyReference()!=null && getReceiverPartyReference().hasData()) return true;
			if (getReceiverAccountReference()!=null && getReceiverAccountReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReceiverModel.ReceiverModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReceiverModel.ReceiverModelBuilder o = (ReceiverModel.ReceiverModelBuilder) other;
			
			merger.mergeRosetta(getReceiverPartyReference(), o.getReceiverPartyReference(), this::setReceiverPartyReference);
			merger.mergeRosetta(getReceiverAccountReference(), o.getReceiverAccountReference(), this::setReceiverAccountReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReceiverModel _that = getType().cast(o);
		
			if (!Objects.equals(receiverPartyReference, _that.getReceiverPartyReference())) return false;
			if (!Objects.equals(receiverAccountReference, _that.getReceiverAccountReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (receiverPartyReference != null ? receiverPartyReference.hashCode() : 0);
			_result = 31 * _result + (receiverAccountReference != null ? receiverAccountReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReceiverModelBuilder {" +
				"receiverPartyReference=" + this.receiverPartyReference + ", " +
				"receiverAccountReference=" + this.receiverAccountReference +
			'}';
		}
	}
}
