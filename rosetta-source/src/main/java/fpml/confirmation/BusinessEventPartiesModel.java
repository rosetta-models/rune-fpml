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
import fpml.confirmation.BusinessEventPartiesModel;
import fpml.confirmation.BusinessEventPartiesModel.BusinessEventPartiesModelBuilder;
import fpml.confirmation.BusinessEventPartiesModel.BusinessEventPartiesModelBuilderImpl;
import fpml.confirmation.BusinessEventPartiesModel.BusinessEventPartiesModelImpl;
import fpml.confirmation.PartyReference;
import fpml.confirmation.meta.BusinessEventPartiesModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A model that represents the main parties involved in any business event.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="BusinessEventPartiesModel", builder=BusinessEventPartiesModel.BusinessEventPartiesModelBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface BusinessEventPartiesModel extends RosettaModelObject {

	BusinessEventPartiesModelMeta metaData = new BusinessEventPartiesModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A reference to the agent bank for the associated deal.
	 */
	PartyReference getAgentPartyReference();
	/**
	 * A reference to the main borrower associated with the specific business event.
	 */
	PartyReference getBorrowerPartyReference();

	/*********************** Build Methods  ***********************/
	BusinessEventPartiesModel build();
	
	BusinessEventPartiesModel.BusinessEventPartiesModelBuilder toBuilder();
	
	static BusinessEventPartiesModel.BusinessEventPartiesModelBuilder builder() {
		return new BusinessEventPartiesModel.BusinessEventPartiesModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends BusinessEventPartiesModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends BusinessEventPartiesModel> getType() {
		return BusinessEventPartiesModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("agentPartyReference"), processor, PartyReference.class, getAgentPartyReference());
		processRosetta(path.newSubPath("borrowerPartyReference"), processor, PartyReference.class, getBorrowerPartyReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface BusinessEventPartiesModelBuilder extends BusinessEventPartiesModel, RosettaModelObjectBuilder {
		PartyReference.PartyReferenceBuilder getOrCreateAgentPartyReference();
		PartyReference.PartyReferenceBuilder getAgentPartyReference();
		PartyReference.PartyReferenceBuilder getOrCreateBorrowerPartyReference();
		PartyReference.PartyReferenceBuilder getBorrowerPartyReference();
		BusinessEventPartiesModel.BusinessEventPartiesModelBuilder setAgentPartyReference(PartyReference agentPartyReference);
		BusinessEventPartiesModel.BusinessEventPartiesModelBuilder setBorrowerPartyReference(PartyReference borrowerPartyReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("agentPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getAgentPartyReference());
			processRosetta(path.newSubPath("borrowerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getBorrowerPartyReference());
		}
		

		BusinessEventPartiesModel.BusinessEventPartiesModelBuilder prune();
	}

	/*********************** Immutable Implementation of BusinessEventPartiesModel  ***********************/
	class BusinessEventPartiesModelImpl implements BusinessEventPartiesModel {
		private final PartyReference agentPartyReference;
		private final PartyReference borrowerPartyReference;
		
		protected BusinessEventPartiesModelImpl(BusinessEventPartiesModel.BusinessEventPartiesModelBuilder builder) {
			this.agentPartyReference = ofNullable(builder.getAgentPartyReference()).map(f->f.build()).orElse(null);
			this.borrowerPartyReference = ofNullable(builder.getBorrowerPartyReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("agentPartyReference")
		public PartyReference getAgentPartyReference() {
			return agentPartyReference;
		}
		
		@Override
		@RosettaAttribute("borrowerPartyReference")
		public PartyReference getBorrowerPartyReference() {
			return borrowerPartyReference;
		}
		
		@Override
		public BusinessEventPartiesModel build() {
			return this;
		}
		
		@Override
		public BusinessEventPartiesModel.BusinessEventPartiesModelBuilder toBuilder() {
			BusinessEventPartiesModel.BusinessEventPartiesModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BusinessEventPartiesModel.BusinessEventPartiesModelBuilder builder) {
			ofNullable(getAgentPartyReference()).ifPresent(builder::setAgentPartyReference);
			ofNullable(getBorrowerPartyReference()).ifPresent(builder::setBorrowerPartyReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BusinessEventPartiesModel _that = getType().cast(o);
		
			if (!Objects.equals(agentPartyReference, _that.getAgentPartyReference())) return false;
			if (!Objects.equals(borrowerPartyReference, _that.getBorrowerPartyReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (agentPartyReference != null ? agentPartyReference.hashCode() : 0);
			_result = 31 * _result + (borrowerPartyReference != null ? borrowerPartyReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BusinessEventPartiesModel {" +
				"agentPartyReference=" + this.agentPartyReference + ", " +
				"borrowerPartyReference=" + this.borrowerPartyReference +
			'}';
		}
	}

	/*********************** Builder Implementation of BusinessEventPartiesModel  ***********************/
	class BusinessEventPartiesModelBuilderImpl implements BusinessEventPartiesModel.BusinessEventPartiesModelBuilder {
	
		protected PartyReference.PartyReferenceBuilder agentPartyReference;
		protected PartyReference.PartyReferenceBuilder borrowerPartyReference;
	
		public BusinessEventPartiesModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("agentPartyReference")
		public PartyReference.PartyReferenceBuilder getAgentPartyReference() {
			return agentPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateAgentPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (agentPartyReference!=null) {
				result = agentPartyReference;
			}
			else {
				result = agentPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("borrowerPartyReference")
		public PartyReference.PartyReferenceBuilder getBorrowerPartyReference() {
			return borrowerPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateBorrowerPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (borrowerPartyReference!=null) {
				result = borrowerPartyReference;
			}
			else {
				result = borrowerPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("agentPartyReference")
		public BusinessEventPartiesModel.BusinessEventPartiesModelBuilder setAgentPartyReference(PartyReference agentPartyReference) {
			this.agentPartyReference = agentPartyReference==null?null:agentPartyReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("borrowerPartyReference")
		public BusinessEventPartiesModel.BusinessEventPartiesModelBuilder setBorrowerPartyReference(PartyReference borrowerPartyReference) {
			this.borrowerPartyReference = borrowerPartyReference==null?null:borrowerPartyReference.toBuilder();
			return this;
		}
		
		@Override
		public BusinessEventPartiesModel build() {
			return new BusinessEventPartiesModel.BusinessEventPartiesModelImpl(this);
		}
		
		@Override
		public BusinessEventPartiesModel.BusinessEventPartiesModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BusinessEventPartiesModel.BusinessEventPartiesModelBuilder prune() {
			if (agentPartyReference!=null && !agentPartyReference.prune().hasData()) agentPartyReference = null;
			if (borrowerPartyReference!=null && !borrowerPartyReference.prune().hasData()) borrowerPartyReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAgentPartyReference()!=null && getAgentPartyReference().hasData()) return true;
			if (getBorrowerPartyReference()!=null && getBorrowerPartyReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BusinessEventPartiesModel.BusinessEventPartiesModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			BusinessEventPartiesModel.BusinessEventPartiesModelBuilder o = (BusinessEventPartiesModel.BusinessEventPartiesModelBuilder) other;
			
			merger.mergeRosetta(getAgentPartyReference(), o.getAgentPartyReference(), this::setAgentPartyReference);
			merger.mergeRosetta(getBorrowerPartyReference(), o.getBorrowerPartyReference(), this::setBorrowerPartyReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BusinessEventPartiesModel _that = getType().cast(o);
		
			if (!Objects.equals(agentPartyReference, _that.getAgentPartyReference())) return false;
			if (!Objects.equals(borrowerPartyReference, _that.getBorrowerPartyReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (agentPartyReference != null ? agentPartyReference.hashCode() : 0);
			_result = 31 * _result + (borrowerPartyReference != null ? borrowerPartyReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BusinessEventPartiesModelBuilder {" +
				"agentPartyReference=" + this.agentPartyReference + ", " +
				"borrowerPartyReference=" + this.borrowerPartyReference +
			'}';
		}
	}
}
