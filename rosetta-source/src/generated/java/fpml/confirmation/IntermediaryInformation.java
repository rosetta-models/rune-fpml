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
import fpml.confirmation.IntermediaryInformation;
import fpml.confirmation.IntermediaryInformation.IntermediaryInformationBuilder;
import fpml.confirmation.IntermediaryInformation.IntermediaryInformationBuilderImpl;
import fpml.confirmation.IntermediaryInformation.IntermediaryInformationImpl;
import fpml.confirmation.PartyReference;
import fpml.confirmation.RoutingIdentificationModel;
import fpml.confirmation.meta.IntermediaryInformationMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type that describes the information to identify an intermediary through which payment will be made by the correspondent bank to the ultimate beneficiary of the funds.
 * @version ${project.version}
 */
@RosettaDataType(value="IntermediaryInformation", builder=IntermediaryInformation.IntermediaryInformationBuilderImpl.class, version="${project.version}")
public interface IntermediaryInformation extends RosettaModelObject {

	IntermediaryInformationMeta metaData = new IntermediaryInformationMeta();

	/*********************** Getter Methods  ***********************/
	RoutingIdentificationModel getRoutingIdentificationModel();
	/**
	 * A sequence number that gives the position of the current intermediary in the chain of payment intermediaries. The assumed domain value set is an ascending sequence of integers starting from 1.
	 */
	Integer getIntermediarySequenceNumber();
	/**
	 * Reference to the party acting as intermediary.
	 */
	PartyReference getIntermediaryPartyReference();

	/*********************** Build Methods  ***********************/
	IntermediaryInformation build();
	
	IntermediaryInformation.IntermediaryInformationBuilder toBuilder();
	
	static IntermediaryInformation.IntermediaryInformationBuilder builder() {
		return new IntermediaryInformation.IntermediaryInformationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends IntermediaryInformation> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends IntermediaryInformation> getType() {
		return IntermediaryInformation.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("routingIdentificationModel"), processor, RoutingIdentificationModel.class, getRoutingIdentificationModel());
		processor.processBasic(path.newSubPath("intermediarySequenceNumber"), Integer.class, getIntermediarySequenceNumber(), this);
		processRosetta(path.newSubPath("intermediaryPartyReference"), processor, PartyReference.class, getIntermediaryPartyReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface IntermediaryInformationBuilder extends IntermediaryInformation, RosettaModelObjectBuilder {
		RoutingIdentificationModel.RoutingIdentificationModelBuilder getOrCreateRoutingIdentificationModel();
		RoutingIdentificationModel.RoutingIdentificationModelBuilder getRoutingIdentificationModel();
		PartyReference.PartyReferenceBuilder getOrCreateIntermediaryPartyReference();
		PartyReference.PartyReferenceBuilder getIntermediaryPartyReference();
		IntermediaryInformation.IntermediaryInformationBuilder setRoutingIdentificationModel(RoutingIdentificationModel routingIdentificationModel);
		IntermediaryInformation.IntermediaryInformationBuilder setIntermediarySequenceNumber(Integer intermediarySequenceNumber);
		IntermediaryInformation.IntermediaryInformationBuilder setIntermediaryPartyReference(PartyReference intermediaryPartyReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("routingIdentificationModel"), processor, RoutingIdentificationModel.RoutingIdentificationModelBuilder.class, getRoutingIdentificationModel());
			processor.processBasic(path.newSubPath("intermediarySequenceNumber"), Integer.class, getIntermediarySequenceNumber(), this);
			processRosetta(path.newSubPath("intermediaryPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getIntermediaryPartyReference());
		}
		

		IntermediaryInformation.IntermediaryInformationBuilder prune();
	}

	/*********************** Immutable Implementation of IntermediaryInformation  ***********************/
	class IntermediaryInformationImpl implements IntermediaryInformation {
		private final RoutingIdentificationModel routingIdentificationModel;
		private final Integer intermediarySequenceNumber;
		private final PartyReference intermediaryPartyReference;
		
		protected IntermediaryInformationImpl(IntermediaryInformation.IntermediaryInformationBuilder builder) {
			this.routingIdentificationModel = ofNullable(builder.getRoutingIdentificationModel()).map(f->f.build()).orElse(null);
			this.intermediarySequenceNumber = builder.getIntermediarySequenceNumber();
			this.intermediaryPartyReference = ofNullable(builder.getIntermediaryPartyReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("routingIdentificationModel")
		public RoutingIdentificationModel getRoutingIdentificationModel() {
			return routingIdentificationModel;
		}
		
		@Override
		@RosettaAttribute("intermediarySequenceNumber")
		public Integer getIntermediarySequenceNumber() {
			return intermediarySequenceNumber;
		}
		
		@Override
		@RosettaAttribute("intermediaryPartyReference")
		public PartyReference getIntermediaryPartyReference() {
			return intermediaryPartyReference;
		}
		
		@Override
		public IntermediaryInformation build() {
			return this;
		}
		
		@Override
		public IntermediaryInformation.IntermediaryInformationBuilder toBuilder() {
			IntermediaryInformation.IntermediaryInformationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(IntermediaryInformation.IntermediaryInformationBuilder builder) {
			ofNullable(getRoutingIdentificationModel()).ifPresent(builder::setRoutingIdentificationModel);
			ofNullable(getIntermediarySequenceNumber()).ifPresent(builder::setIntermediarySequenceNumber);
			ofNullable(getIntermediaryPartyReference()).ifPresent(builder::setIntermediaryPartyReference);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			IntermediaryInformation _that = getType().cast(o);
		
			if (!Objects.equals(routingIdentificationModel, _that.getRoutingIdentificationModel())) return false;
			if (!Objects.equals(intermediarySequenceNumber, _that.getIntermediarySequenceNumber())) return false;
			if (!Objects.equals(intermediaryPartyReference, _that.getIntermediaryPartyReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (routingIdentificationModel != null ? routingIdentificationModel.hashCode() : 0);
			_result = 31 * _result + (intermediarySequenceNumber != null ? intermediarySequenceNumber.hashCode() : 0);
			_result = 31 * _result + (intermediaryPartyReference != null ? intermediaryPartyReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IntermediaryInformation {" +
				"routingIdentificationModel=" + this.routingIdentificationModel + ", " +
				"intermediarySequenceNumber=" + this.intermediarySequenceNumber + ", " +
				"intermediaryPartyReference=" + this.intermediaryPartyReference +
			'}';
		}
	}

	/*********************** Builder Implementation of IntermediaryInformation  ***********************/
	class IntermediaryInformationBuilderImpl implements IntermediaryInformation.IntermediaryInformationBuilder {
	
		protected RoutingIdentificationModel.RoutingIdentificationModelBuilder routingIdentificationModel;
		protected Integer intermediarySequenceNumber;
		protected PartyReference.PartyReferenceBuilder intermediaryPartyReference;
	
		public IntermediaryInformationBuilderImpl() {
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
		@RosettaAttribute("intermediarySequenceNumber")
		public Integer getIntermediarySequenceNumber() {
			return intermediarySequenceNumber;
		}
		
		@Override
		@RosettaAttribute("intermediaryPartyReference")
		public PartyReference.PartyReferenceBuilder getIntermediaryPartyReference() {
			return intermediaryPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateIntermediaryPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (intermediaryPartyReference!=null) {
				result = intermediaryPartyReference;
			}
			else {
				result = intermediaryPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("routingIdentificationModel")
		public IntermediaryInformation.IntermediaryInformationBuilder setRoutingIdentificationModel(RoutingIdentificationModel routingIdentificationModel) {
			this.routingIdentificationModel = routingIdentificationModel==null?null:routingIdentificationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("intermediarySequenceNumber")
		public IntermediaryInformation.IntermediaryInformationBuilder setIntermediarySequenceNumber(Integer intermediarySequenceNumber) {
			this.intermediarySequenceNumber = intermediarySequenceNumber==null?null:intermediarySequenceNumber;
			return this;
		}
		@Override
		@RosettaAttribute("intermediaryPartyReference")
		public IntermediaryInformation.IntermediaryInformationBuilder setIntermediaryPartyReference(PartyReference intermediaryPartyReference) {
			this.intermediaryPartyReference = intermediaryPartyReference==null?null:intermediaryPartyReference.toBuilder();
			return this;
		}
		
		@Override
		public IntermediaryInformation build() {
			return new IntermediaryInformation.IntermediaryInformationImpl(this);
		}
		
		@Override
		public IntermediaryInformation.IntermediaryInformationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IntermediaryInformation.IntermediaryInformationBuilder prune() {
			if (routingIdentificationModel!=null && !routingIdentificationModel.prune().hasData()) routingIdentificationModel = null;
			if (intermediaryPartyReference!=null && !intermediaryPartyReference.prune().hasData()) intermediaryPartyReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getRoutingIdentificationModel()!=null && getRoutingIdentificationModel().hasData()) return true;
			if (getIntermediarySequenceNumber()!=null) return true;
			if (getIntermediaryPartyReference()!=null && getIntermediaryPartyReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IntermediaryInformation.IntermediaryInformationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			IntermediaryInformation.IntermediaryInformationBuilder o = (IntermediaryInformation.IntermediaryInformationBuilder) other;
			
			merger.mergeRosetta(getRoutingIdentificationModel(), o.getRoutingIdentificationModel(), this::setRoutingIdentificationModel);
			merger.mergeRosetta(getIntermediaryPartyReference(), o.getIntermediaryPartyReference(), this::setIntermediaryPartyReference);
			
			merger.mergeBasic(getIntermediarySequenceNumber(), o.getIntermediarySequenceNumber(), this::setIntermediarySequenceNumber);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			IntermediaryInformation _that = getType().cast(o);
		
			if (!Objects.equals(routingIdentificationModel, _that.getRoutingIdentificationModel())) return false;
			if (!Objects.equals(intermediarySequenceNumber, _that.getIntermediarySequenceNumber())) return false;
			if (!Objects.equals(intermediaryPartyReference, _that.getIntermediaryPartyReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (routingIdentificationModel != null ? routingIdentificationModel.hashCode() : 0);
			_result = 31 * _result + (intermediarySequenceNumber != null ? intermediarySequenceNumber.hashCode() : 0);
			_result = 31 * _result + (intermediaryPartyReference != null ? intermediaryPartyReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IntermediaryInformationBuilder {" +
				"routingIdentificationModel=" + this.routingIdentificationModel + ", " +
				"intermediarySequenceNumber=" + this.intermediarySequenceNumber + ", " +
				"intermediaryPartyReference=" + this.intermediaryPartyReference +
			'}';
		}
	}
}
