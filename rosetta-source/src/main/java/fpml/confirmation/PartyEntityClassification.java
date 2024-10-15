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
import fpml.confirmation.EntityClassification;
import fpml.confirmation.PartyEntityClassification;
import fpml.confirmation.PartyEntityClassification.PartyEntityClassificationBuilder;
import fpml.confirmation.PartyEntityClassification.PartyEntityClassificationBuilderImpl;
import fpml.confirmation.PartyEntityClassification.PartyEntityClassificationImpl;
import fpml.confirmation.PartyReference;
import fpml.confirmation.meta.PartyEntityClassificationMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type that specifies the classification of a party.
 * @version ${project.version}
 */
@RosettaDataType(value="PartyEntityClassification", builder=PartyEntityClassification.PartyEntityClassificationBuilderImpl.class, version="${project.version}")
public interface PartyEntityClassification extends RosettaModelObject {

	PartyEntityClassificationMeta metaData = new PartyEntityClassificationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A pointer style reference to a party identifier defined elsewhere in the document. The party referenced has the classification in the associated &quot;entityClassification&quot; element below.
	 */
	PartyReference getPartyReference();
	/**
	 * Indicates the category or classification or business role of the organization referenced by the partyTradeInformation with respect to this reporting regime, for example Financial, NonFinancial etc.
	 */
	EntityClassification getEntityClassification();

	/*********************** Build Methods  ***********************/
	PartyEntityClassification build();
	
	PartyEntityClassification.PartyEntityClassificationBuilder toBuilder();
	
	static PartyEntityClassification.PartyEntityClassificationBuilder builder() {
		return new PartyEntityClassification.PartyEntityClassificationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PartyEntityClassification> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PartyEntityClassification> getType() {
		return PartyEntityClassification.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("partyReference"), processor, PartyReference.class, getPartyReference());
		processRosetta(path.newSubPath("entityClassification"), processor, EntityClassification.class, getEntityClassification());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PartyEntityClassificationBuilder extends PartyEntityClassification, RosettaModelObjectBuilder {
		PartyReference.PartyReferenceBuilder getOrCreatePartyReference();
		PartyReference.PartyReferenceBuilder getPartyReference();
		EntityClassification.EntityClassificationBuilder getOrCreateEntityClassification();
		EntityClassification.EntityClassificationBuilder getEntityClassification();
		PartyEntityClassification.PartyEntityClassificationBuilder setPartyReference(PartyReference partyReference);
		PartyEntityClassification.PartyEntityClassificationBuilder setEntityClassification(EntityClassification entityClassification);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("partyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPartyReference());
			processRosetta(path.newSubPath("entityClassification"), processor, EntityClassification.EntityClassificationBuilder.class, getEntityClassification());
		}
		

		PartyEntityClassification.PartyEntityClassificationBuilder prune();
	}

	/*********************** Immutable Implementation of PartyEntityClassification  ***********************/
	class PartyEntityClassificationImpl implements PartyEntityClassification {
		private final PartyReference partyReference;
		private final EntityClassification entityClassification;
		
		protected PartyEntityClassificationImpl(PartyEntityClassification.PartyEntityClassificationBuilder builder) {
			this.partyReference = ofNullable(builder.getPartyReference()).map(f->f.build()).orElse(null);
			this.entityClassification = ofNullable(builder.getEntityClassification()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("partyReference")
		public PartyReference getPartyReference() {
			return partyReference;
		}
		
		@Override
		@RosettaAttribute("entityClassification")
		public EntityClassification getEntityClassification() {
			return entityClassification;
		}
		
		@Override
		public PartyEntityClassification build() {
			return this;
		}
		
		@Override
		public PartyEntityClassification.PartyEntityClassificationBuilder toBuilder() {
			PartyEntityClassification.PartyEntityClassificationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PartyEntityClassification.PartyEntityClassificationBuilder builder) {
			ofNullable(getPartyReference()).ifPresent(builder::setPartyReference);
			ofNullable(getEntityClassification()).ifPresent(builder::setEntityClassification);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyEntityClassification _that = getType().cast(o);
		
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			if (!Objects.equals(entityClassification, _that.getEntityClassification())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			_result = 31 * _result + (entityClassification != null ? entityClassification.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyEntityClassification {" +
				"partyReference=" + this.partyReference + ", " +
				"entityClassification=" + this.entityClassification +
			'}';
		}
	}

	/*********************** Builder Implementation of PartyEntityClassification  ***********************/
	class PartyEntityClassificationBuilderImpl implements PartyEntityClassification.PartyEntityClassificationBuilder {
	
		protected PartyReference.PartyReferenceBuilder partyReference;
		protected EntityClassification.EntityClassificationBuilder entityClassification;
	
		public PartyEntityClassificationBuilderImpl() {
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
		@RosettaAttribute("entityClassification")
		public EntityClassification.EntityClassificationBuilder getEntityClassification() {
			return entityClassification;
		}
		
		@Override
		public EntityClassification.EntityClassificationBuilder getOrCreateEntityClassification() {
			EntityClassification.EntityClassificationBuilder result;
			if (entityClassification!=null) {
				result = entityClassification;
			}
			else {
				result = entityClassification = EntityClassification.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("partyReference")
		public PartyEntityClassification.PartyEntityClassificationBuilder setPartyReference(PartyReference partyReference) {
			this.partyReference = partyReference==null?null:partyReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("entityClassification")
		public PartyEntityClassification.PartyEntityClassificationBuilder setEntityClassification(EntityClassification entityClassification) {
			this.entityClassification = entityClassification==null?null:entityClassification.toBuilder();
			return this;
		}
		
		@Override
		public PartyEntityClassification build() {
			return new PartyEntityClassification.PartyEntityClassificationImpl(this);
		}
		
		@Override
		public PartyEntityClassification.PartyEntityClassificationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyEntityClassification.PartyEntityClassificationBuilder prune() {
			if (partyReference!=null && !partyReference.prune().hasData()) partyReference = null;
			if (entityClassification!=null && !entityClassification.prune().hasData()) entityClassification = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPartyReference()!=null && getPartyReference().hasData()) return true;
			if (getEntityClassification()!=null && getEntityClassification().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyEntityClassification.PartyEntityClassificationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PartyEntityClassification.PartyEntityClassificationBuilder o = (PartyEntityClassification.PartyEntityClassificationBuilder) other;
			
			merger.mergeRosetta(getPartyReference(), o.getPartyReference(), this::setPartyReference);
			merger.mergeRosetta(getEntityClassification(), o.getEntityClassification(), this::setEntityClassification);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyEntityClassification _that = getType().cast(o);
		
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			if (!Objects.equals(entityClassification, _that.getEntityClassification())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			_result = 31 * _result + (entityClassification != null ? entityClassification.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyEntityClassificationBuilder {" +
				"partyReference=" + this.partyReference + ", " +
				"entityClassification=" + this.entityClassification +
			'}';
		}
	}
}
