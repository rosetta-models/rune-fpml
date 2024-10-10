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
import fpml.confirmation.ClearingInstructions;
import fpml.confirmation.ClearingInstructions.ClearingInstructionsBuilder;
import fpml.confirmation.ClearingInstructions.ClearingInstructionsBuilderImpl;
import fpml.confirmation.ClearingInstructions.ClearingInstructionsImpl;
import fpml.confirmation.PartyReference;
import fpml.confirmation.RequestedClearingAction;
import fpml.confirmation.meta.ClearingInstructionsMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="ClearingInstructions", builder=ClearingInstructions.ClearingInstructionsBuilderImpl.class, version="${project.version}")
public interface ClearingInstructions extends RosettaModelObject {

	ClearingInstructionsMeta metaData = new ClearingInstructionsMeta();

	/*********************** Getter Methods  ***********************/
	RequestedClearingAction getRequestedClearingAction();
	PartyReference getRequestedClearingOrganizationPartyReference();

	/*********************** Build Methods  ***********************/
	ClearingInstructions build();
	
	ClearingInstructions.ClearingInstructionsBuilder toBuilder();
	
	static ClearingInstructions.ClearingInstructionsBuilder builder() {
		return new ClearingInstructions.ClearingInstructionsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ClearingInstructions> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ClearingInstructions> getType() {
		return ClearingInstructions.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("requestedClearingAction"), processor, RequestedClearingAction.class, getRequestedClearingAction());
		processRosetta(path.newSubPath("requestedClearingOrganizationPartyReference"), processor, PartyReference.class, getRequestedClearingOrganizationPartyReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ClearingInstructionsBuilder extends ClearingInstructions, RosettaModelObjectBuilder {
		RequestedClearingAction.RequestedClearingActionBuilder getOrCreateRequestedClearingAction();
		RequestedClearingAction.RequestedClearingActionBuilder getRequestedClearingAction();
		PartyReference.PartyReferenceBuilder getOrCreateRequestedClearingOrganizationPartyReference();
		PartyReference.PartyReferenceBuilder getRequestedClearingOrganizationPartyReference();
		ClearingInstructions.ClearingInstructionsBuilder setRequestedClearingAction(RequestedClearingAction requestedClearingAction);
		ClearingInstructions.ClearingInstructionsBuilder setRequestedClearingOrganizationPartyReference(PartyReference requestedClearingOrganizationPartyReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("requestedClearingAction"), processor, RequestedClearingAction.RequestedClearingActionBuilder.class, getRequestedClearingAction());
			processRosetta(path.newSubPath("requestedClearingOrganizationPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getRequestedClearingOrganizationPartyReference());
		}
		

		ClearingInstructions.ClearingInstructionsBuilder prune();
	}

	/*********************** Immutable Implementation of ClearingInstructions  ***********************/
	class ClearingInstructionsImpl implements ClearingInstructions {
		private final RequestedClearingAction requestedClearingAction;
		private final PartyReference requestedClearingOrganizationPartyReference;
		
		protected ClearingInstructionsImpl(ClearingInstructions.ClearingInstructionsBuilder builder) {
			this.requestedClearingAction = ofNullable(builder.getRequestedClearingAction()).map(f->f.build()).orElse(null);
			this.requestedClearingOrganizationPartyReference = ofNullable(builder.getRequestedClearingOrganizationPartyReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("requestedClearingAction")
		public RequestedClearingAction getRequestedClearingAction() {
			return requestedClearingAction;
		}
		
		@Override
		@RosettaAttribute("requestedClearingOrganizationPartyReference")
		public PartyReference getRequestedClearingOrganizationPartyReference() {
			return requestedClearingOrganizationPartyReference;
		}
		
		@Override
		public ClearingInstructions build() {
			return this;
		}
		
		@Override
		public ClearingInstructions.ClearingInstructionsBuilder toBuilder() {
			ClearingInstructions.ClearingInstructionsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ClearingInstructions.ClearingInstructionsBuilder builder) {
			ofNullable(getRequestedClearingAction()).ifPresent(builder::setRequestedClearingAction);
			ofNullable(getRequestedClearingOrganizationPartyReference()).ifPresent(builder::setRequestedClearingOrganizationPartyReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ClearingInstructions _that = getType().cast(o);
		
			if (!Objects.equals(requestedClearingAction, _that.getRequestedClearingAction())) return false;
			if (!Objects.equals(requestedClearingOrganizationPartyReference, _that.getRequestedClearingOrganizationPartyReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (requestedClearingAction != null ? requestedClearingAction.hashCode() : 0);
			_result = 31 * _result + (requestedClearingOrganizationPartyReference != null ? requestedClearingOrganizationPartyReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ClearingInstructions {" +
				"requestedClearingAction=" + this.requestedClearingAction + ", " +
				"requestedClearingOrganizationPartyReference=" + this.requestedClearingOrganizationPartyReference +
			'}';
		}
	}

	/*********************** Builder Implementation of ClearingInstructions  ***********************/
	class ClearingInstructionsBuilderImpl implements ClearingInstructions.ClearingInstructionsBuilder {
	
		protected RequestedClearingAction.RequestedClearingActionBuilder requestedClearingAction;
		protected PartyReference.PartyReferenceBuilder requestedClearingOrganizationPartyReference;
	
		public ClearingInstructionsBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("requestedClearingAction")
		public RequestedClearingAction.RequestedClearingActionBuilder getRequestedClearingAction() {
			return requestedClearingAction;
		}
		
		@Override
		public RequestedClearingAction.RequestedClearingActionBuilder getOrCreateRequestedClearingAction() {
			RequestedClearingAction.RequestedClearingActionBuilder result;
			if (requestedClearingAction!=null) {
				result = requestedClearingAction;
			}
			else {
				result = requestedClearingAction = RequestedClearingAction.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("requestedClearingOrganizationPartyReference")
		public PartyReference.PartyReferenceBuilder getRequestedClearingOrganizationPartyReference() {
			return requestedClearingOrganizationPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateRequestedClearingOrganizationPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (requestedClearingOrganizationPartyReference!=null) {
				result = requestedClearingOrganizationPartyReference;
			}
			else {
				result = requestedClearingOrganizationPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("requestedClearingAction")
		public ClearingInstructions.ClearingInstructionsBuilder setRequestedClearingAction(RequestedClearingAction requestedClearingAction) {
			this.requestedClearingAction = requestedClearingAction==null?null:requestedClearingAction.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("requestedClearingOrganizationPartyReference")
		public ClearingInstructions.ClearingInstructionsBuilder setRequestedClearingOrganizationPartyReference(PartyReference requestedClearingOrganizationPartyReference) {
			this.requestedClearingOrganizationPartyReference = requestedClearingOrganizationPartyReference==null?null:requestedClearingOrganizationPartyReference.toBuilder();
			return this;
		}
		
		@Override
		public ClearingInstructions build() {
			return new ClearingInstructions.ClearingInstructionsImpl(this);
		}
		
		@Override
		public ClearingInstructions.ClearingInstructionsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ClearingInstructions.ClearingInstructionsBuilder prune() {
			if (requestedClearingAction!=null && !requestedClearingAction.prune().hasData()) requestedClearingAction = null;
			if (requestedClearingOrganizationPartyReference!=null && !requestedClearingOrganizationPartyReference.prune().hasData()) requestedClearingOrganizationPartyReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getRequestedClearingAction()!=null && getRequestedClearingAction().hasData()) return true;
			if (getRequestedClearingOrganizationPartyReference()!=null && getRequestedClearingOrganizationPartyReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ClearingInstructions.ClearingInstructionsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ClearingInstructions.ClearingInstructionsBuilder o = (ClearingInstructions.ClearingInstructionsBuilder) other;
			
			merger.mergeRosetta(getRequestedClearingAction(), o.getRequestedClearingAction(), this::setRequestedClearingAction);
			merger.mergeRosetta(getRequestedClearingOrganizationPartyReference(), o.getRequestedClearingOrganizationPartyReference(), this::setRequestedClearingOrganizationPartyReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ClearingInstructions _that = getType().cast(o);
		
			if (!Objects.equals(requestedClearingAction, _that.getRequestedClearingAction())) return false;
			if (!Objects.equals(requestedClearingOrganizationPartyReference, _that.getRequestedClearingOrganizationPartyReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (requestedClearingAction != null ? requestedClearingAction.hashCode() : 0);
			_result = 31 * _result + (requestedClearingOrganizationPartyReference != null ? requestedClearingOrganizationPartyReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ClearingInstructionsBuilder {" +
				"requestedClearingAction=" + this.requestedClearingAction + ", " +
				"requestedClearingOrganizationPartyReference=" + this.requestedClearingOrganizationPartyReference +
			'}';
		}
	}
}
