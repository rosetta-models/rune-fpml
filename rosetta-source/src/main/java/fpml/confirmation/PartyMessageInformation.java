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
import fpml.confirmation.PartyMessageInformation;
import fpml.confirmation.PartyMessageInformation.PartyMessageInformationBuilder;
import fpml.confirmation.PartyMessageInformation.PartyMessageInformationBuilderImpl;
import fpml.confirmation.PartyMessageInformation.PartyMessageInformationImpl;
import fpml.confirmation.PartyReference;
import fpml.confirmation.meta.PartyMessageInformationMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type defining additional information that may be recorded against a message.
 * @version ${project.version}
 */
@RosettaDataType(value="PartyMessageInformation", builder=PartyMessageInformation.PartyMessageInformationBuilderImpl.class, version="${project.version}")
public interface PartyMessageInformation extends RosettaModelObject {

	PartyMessageInformationMeta metaData = new PartyMessageInformationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Identifies that party that has ownership of this information.
	 */
	PartyReference getPartyReference();

	/*********************** Build Methods  ***********************/
	PartyMessageInformation build();
	
	PartyMessageInformation.PartyMessageInformationBuilder toBuilder();
	
	static PartyMessageInformation.PartyMessageInformationBuilder builder() {
		return new PartyMessageInformation.PartyMessageInformationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PartyMessageInformation> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PartyMessageInformation> getType() {
		return PartyMessageInformation.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("partyReference"), processor, PartyReference.class, getPartyReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PartyMessageInformationBuilder extends PartyMessageInformation, RosettaModelObjectBuilder {
		PartyReference.PartyReferenceBuilder getOrCreatePartyReference();
		PartyReference.PartyReferenceBuilder getPartyReference();
		PartyMessageInformation.PartyMessageInformationBuilder setPartyReference(PartyReference partyReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("partyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPartyReference());
		}
		

		PartyMessageInformation.PartyMessageInformationBuilder prune();
	}

	/*********************** Immutable Implementation of PartyMessageInformation  ***********************/
	class PartyMessageInformationImpl implements PartyMessageInformation {
		private final PartyReference partyReference;
		
		protected PartyMessageInformationImpl(PartyMessageInformation.PartyMessageInformationBuilder builder) {
			this.partyReference = ofNullable(builder.getPartyReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("partyReference")
		public PartyReference getPartyReference() {
			return partyReference;
		}
		
		@Override
		public PartyMessageInformation build() {
			return this;
		}
		
		@Override
		public PartyMessageInformation.PartyMessageInformationBuilder toBuilder() {
			PartyMessageInformation.PartyMessageInformationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PartyMessageInformation.PartyMessageInformationBuilder builder) {
			ofNullable(getPartyReference()).ifPresent(builder::setPartyReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyMessageInformation _that = getType().cast(o);
		
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyMessageInformation {" +
				"partyReference=" + this.partyReference +
			'}';
		}
	}

	/*********************** Builder Implementation of PartyMessageInformation  ***********************/
	class PartyMessageInformationBuilderImpl implements PartyMessageInformation.PartyMessageInformationBuilder {
	
		protected PartyReference.PartyReferenceBuilder partyReference;
	
		public PartyMessageInformationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("partyReference")
		public PartyReference.PartyReferenceBuilder getPartyReference() {
			return partyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreatePartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (partyReference!=null) {
				result = partyReference;
			}
			else {
				result = partyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("partyReference")
		public PartyMessageInformation.PartyMessageInformationBuilder setPartyReference(PartyReference partyReference) {
			this.partyReference = partyReference==null?null:partyReference.toBuilder();
			return this;
		}
		
		@Override
		public PartyMessageInformation build() {
			return new PartyMessageInformation.PartyMessageInformationImpl(this);
		}
		
		@Override
		public PartyMessageInformation.PartyMessageInformationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyMessageInformation.PartyMessageInformationBuilder prune() {
			if (partyReference!=null && !partyReference.prune().hasData()) partyReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPartyReference()!=null && getPartyReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyMessageInformation.PartyMessageInformationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PartyMessageInformation.PartyMessageInformationBuilder o = (PartyMessageInformation.PartyMessageInformationBuilder) other;
			
			merger.mergeRosetta(getPartyReference(), o.getPartyReference(), this::setPartyReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyMessageInformation _that = getType().cast(o);
		
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyMessageInformationBuilder {" +
				"partyReference=" + this.partyReference +
			'}';
		}
	}
}
