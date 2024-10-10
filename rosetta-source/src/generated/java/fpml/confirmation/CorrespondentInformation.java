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
import fpml.confirmation.CorrespondentInformation;
import fpml.confirmation.CorrespondentInformation.CorrespondentInformationBuilder;
import fpml.confirmation.CorrespondentInformation.CorrespondentInformationBuilderImpl;
import fpml.confirmation.CorrespondentInformation.CorrespondentInformationImpl;
import fpml.confirmation.PartyReference;
import fpml.confirmation.RoutingIdentificationModel;
import fpml.confirmation.meta.CorrespondentInformationMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type that describes the information to identify a correspondent bank that will make delivery of the funds on the paying bank&#39;s behalf in the country where the payment is to be made.
 * @version ${project.version}
 */
@RosettaDataType(value="CorrespondentInformation", builder=CorrespondentInformation.CorrespondentInformationBuilderImpl.class, version="${project.version}")
public interface CorrespondentInformation extends RosettaModelObject {

	CorrespondentInformationMeta metaData = new CorrespondentInformationMeta();

	/*********************** Getter Methods  ***********************/
	RoutingIdentificationModel getRoutingIdentificationModel();
	/**
	 * Link to the party acting as correspondent. This element can only appear within the correspondentInformation container element.
	 */
	PartyReference getCorrespondentPartyReference();

	/*********************** Build Methods  ***********************/
	CorrespondentInformation build();
	
	CorrespondentInformation.CorrespondentInformationBuilder toBuilder();
	
	static CorrespondentInformation.CorrespondentInformationBuilder builder() {
		return new CorrespondentInformation.CorrespondentInformationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CorrespondentInformation> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CorrespondentInformation> getType() {
		return CorrespondentInformation.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("routingIdentificationModel"), processor, RoutingIdentificationModel.class, getRoutingIdentificationModel());
		processRosetta(path.newSubPath("correspondentPartyReference"), processor, PartyReference.class, getCorrespondentPartyReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CorrespondentInformationBuilder extends CorrespondentInformation, RosettaModelObjectBuilder {
		RoutingIdentificationModel.RoutingIdentificationModelBuilder getOrCreateRoutingIdentificationModel();
		RoutingIdentificationModel.RoutingIdentificationModelBuilder getRoutingIdentificationModel();
		PartyReference.PartyReferenceBuilder getOrCreateCorrespondentPartyReference();
		PartyReference.PartyReferenceBuilder getCorrespondentPartyReference();
		CorrespondentInformation.CorrespondentInformationBuilder setRoutingIdentificationModel(RoutingIdentificationModel routingIdentificationModel);
		CorrespondentInformation.CorrespondentInformationBuilder setCorrespondentPartyReference(PartyReference correspondentPartyReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("routingIdentificationModel"), processor, RoutingIdentificationModel.RoutingIdentificationModelBuilder.class, getRoutingIdentificationModel());
			processRosetta(path.newSubPath("correspondentPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getCorrespondentPartyReference());
		}
		

		CorrespondentInformation.CorrespondentInformationBuilder prune();
	}

	/*********************** Immutable Implementation of CorrespondentInformation  ***********************/
	class CorrespondentInformationImpl implements CorrespondentInformation {
		private final RoutingIdentificationModel routingIdentificationModel;
		private final PartyReference correspondentPartyReference;
		
		protected CorrespondentInformationImpl(CorrespondentInformation.CorrespondentInformationBuilder builder) {
			this.routingIdentificationModel = ofNullable(builder.getRoutingIdentificationModel()).map(f->f.build()).orElse(null);
			this.correspondentPartyReference = ofNullable(builder.getCorrespondentPartyReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("routingIdentificationModel")
		public RoutingIdentificationModel getRoutingIdentificationModel() {
			return routingIdentificationModel;
		}
		
		@Override
		@RosettaAttribute("correspondentPartyReference")
		public PartyReference getCorrespondentPartyReference() {
			return correspondentPartyReference;
		}
		
		@Override
		public CorrespondentInformation build() {
			return this;
		}
		
		@Override
		public CorrespondentInformation.CorrespondentInformationBuilder toBuilder() {
			CorrespondentInformation.CorrespondentInformationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CorrespondentInformation.CorrespondentInformationBuilder builder) {
			ofNullable(getRoutingIdentificationModel()).ifPresent(builder::setRoutingIdentificationModel);
			ofNullable(getCorrespondentPartyReference()).ifPresent(builder::setCorrespondentPartyReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CorrespondentInformation _that = getType().cast(o);
		
			if (!Objects.equals(routingIdentificationModel, _that.getRoutingIdentificationModel())) return false;
			if (!Objects.equals(correspondentPartyReference, _that.getCorrespondentPartyReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (routingIdentificationModel != null ? routingIdentificationModel.hashCode() : 0);
			_result = 31 * _result + (correspondentPartyReference != null ? correspondentPartyReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CorrespondentInformation {" +
				"routingIdentificationModel=" + this.routingIdentificationModel + ", " +
				"correspondentPartyReference=" + this.correspondentPartyReference +
			'}';
		}
	}

	/*********************** Builder Implementation of CorrespondentInformation  ***********************/
	class CorrespondentInformationBuilderImpl implements CorrespondentInformation.CorrespondentInformationBuilder {
	
		protected RoutingIdentificationModel.RoutingIdentificationModelBuilder routingIdentificationModel;
		protected PartyReference.PartyReferenceBuilder correspondentPartyReference;
	
		public CorrespondentInformationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("routingIdentificationModel")
		public RoutingIdentificationModel.RoutingIdentificationModelBuilder getRoutingIdentificationModel() {
			return routingIdentificationModel;
		}
		
		@Override
		public RoutingIdentificationModel.RoutingIdentificationModelBuilder getOrCreateRoutingIdentificationModel() {
			RoutingIdentificationModel.RoutingIdentificationModelBuilder result;
			if (routingIdentificationModel!=null) {
				result = routingIdentificationModel;
			}
			else {
				result = routingIdentificationModel = RoutingIdentificationModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("correspondentPartyReference")
		public PartyReference.PartyReferenceBuilder getCorrespondentPartyReference() {
			return correspondentPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateCorrespondentPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (correspondentPartyReference!=null) {
				result = correspondentPartyReference;
			}
			else {
				result = correspondentPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("routingIdentificationModel")
		public CorrespondentInformation.CorrespondentInformationBuilder setRoutingIdentificationModel(RoutingIdentificationModel routingIdentificationModel) {
			this.routingIdentificationModel = routingIdentificationModel==null?null:routingIdentificationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correspondentPartyReference")
		public CorrespondentInformation.CorrespondentInformationBuilder setCorrespondentPartyReference(PartyReference correspondentPartyReference) {
			this.correspondentPartyReference = correspondentPartyReference==null?null:correspondentPartyReference.toBuilder();
			return this;
		}
		
		@Override
		public CorrespondentInformation build() {
			return new CorrespondentInformation.CorrespondentInformationImpl(this);
		}
		
		@Override
		public CorrespondentInformation.CorrespondentInformationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CorrespondentInformation.CorrespondentInformationBuilder prune() {
			if (routingIdentificationModel!=null && !routingIdentificationModel.prune().hasData()) routingIdentificationModel = null;
			if (correspondentPartyReference!=null && !correspondentPartyReference.prune().hasData()) correspondentPartyReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getRoutingIdentificationModel()!=null && getRoutingIdentificationModel().hasData()) return true;
			if (getCorrespondentPartyReference()!=null && getCorrespondentPartyReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CorrespondentInformation.CorrespondentInformationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CorrespondentInformation.CorrespondentInformationBuilder o = (CorrespondentInformation.CorrespondentInformationBuilder) other;
			
			merger.mergeRosetta(getRoutingIdentificationModel(), o.getRoutingIdentificationModel(), this::setRoutingIdentificationModel);
			merger.mergeRosetta(getCorrespondentPartyReference(), o.getCorrespondentPartyReference(), this::setCorrespondentPartyReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CorrespondentInformation _that = getType().cast(o);
		
			if (!Objects.equals(routingIdentificationModel, _that.getRoutingIdentificationModel())) return false;
			if (!Objects.equals(correspondentPartyReference, _that.getCorrespondentPartyReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (routingIdentificationModel != null ? routingIdentificationModel.hashCode() : 0);
			_result = 31 * _result + (correspondentPartyReference != null ? correspondentPartyReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CorrespondentInformationBuilder {" +
				"routingIdentificationModel=" + this.routingIdentificationModel + ", " +
				"correspondentPartyReference=" + this.correspondentPartyReference +
			'}';
		}
	}
}
