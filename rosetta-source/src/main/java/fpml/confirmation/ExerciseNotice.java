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
import fpml.confirmation.BusinessCenter;
import fpml.confirmation.ExerciseNotice;
import fpml.confirmation.ExerciseNotice.ExerciseNoticeBuilder;
import fpml.confirmation.ExerciseNotice.ExerciseNoticeBuilderImpl;
import fpml.confirmation.ExerciseNotice.ExerciseNoticeImpl;
import fpml.confirmation.PartyReference;
import fpml.confirmation.meta.ExerciseNoticeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type defining to whom and where notice of execution should be given. The partyReference refers to one of the principal parties of the trade. If present the exerciseNoticePartyReference refers to a party, other than the principal party, to whome notice should be given.
 * @version ${project.version}
 */
@RosettaDataType(value="ExerciseNotice", builder=ExerciseNotice.ExerciseNoticeBuilderImpl.class, version="${project.version}")
public interface ExerciseNotice extends RosettaModelObject {

	ExerciseNoticeMeta metaData = new ExerciseNoticeMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The party referenced has allocated the trade identifier.
	 */
	PartyReference getPartyReference();
	/**
	 * The party referenced is the party to which notice of exercise should be given by the buyer.
	 */
	PartyReference getExerciseNoticePartyReference();
	BusinessCenter getBusinessCenter();

	/*********************** Build Methods  ***********************/
	ExerciseNotice build();
	
	ExerciseNotice.ExerciseNoticeBuilder toBuilder();
	
	static ExerciseNotice.ExerciseNoticeBuilder builder() {
		return new ExerciseNotice.ExerciseNoticeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ExerciseNotice> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ExerciseNotice> getType() {
		return ExerciseNotice.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("partyReference"), processor, PartyReference.class, getPartyReference());
		processRosetta(path.newSubPath("exerciseNoticePartyReference"), processor, PartyReference.class, getExerciseNoticePartyReference());
		processRosetta(path.newSubPath("businessCenter"), processor, BusinessCenter.class, getBusinessCenter());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ExerciseNoticeBuilder extends ExerciseNotice, RosettaModelObjectBuilder {
		PartyReference.PartyReferenceBuilder getOrCreatePartyReference();
		PartyReference.PartyReferenceBuilder getPartyReference();
		PartyReference.PartyReferenceBuilder getOrCreateExerciseNoticePartyReference();
		PartyReference.PartyReferenceBuilder getExerciseNoticePartyReference();
		BusinessCenter.BusinessCenterBuilder getOrCreateBusinessCenter();
		BusinessCenter.BusinessCenterBuilder getBusinessCenter();
		ExerciseNotice.ExerciseNoticeBuilder setPartyReference(PartyReference partyReference);
		ExerciseNotice.ExerciseNoticeBuilder setExerciseNoticePartyReference(PartyReference exerciseNoticePartyReference);
		ExerciseNotice.ExerciseNoticeBuilder setBusinessCenter(BusinessCenter businessCenter);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("partyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPartyReference());
			processRosetta(path.newSubPath("exerciseNoticePartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getExerciseNoticePartyReference());
			processRosetta(path.newSubPath("businessCenter"), processor, BusinessCenter.BusinessCenterBuilder.class, getBusinessCenter());
		}
		

		ExerciseNotice.ExerciseNoticeBuilder prune();
	}

	/*********************** Immutable Implementation of ExerciseNotice  ***********************/
	class ExerciseNoticeImpl implements ExerciseNotice {
		private final PartyReference partyReference;
		private final PartyReference exerciseNoticePartyReference;
		private final BusinessCenter businessCenter;
		
		protected ExerciseNoticeImpl(ExerciseNotice.ExerciseNoticeBuilder builder) {
			this.partyReference = ofNullable(builder.getPartyReference()).map(f->f.build()).orElse(null);
			this.exerciseNoticePartyReference = ofNullable(builder.getExerciseNoticePartyReference()).map(f->f.build()).orElse(null);
			this.businessCenter = ofNullable(builder.getBusinessCenter()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("partyReference")
		public PartyReference getPartyReference() {
			return partyReference;
		}
		
		@Override
		@RosettaAttribute("exerciseNoticePartyReference")
		public PartyReference getExerciseNoticePartyReference() {
			return exerciseNoticePartyReference;
		}
		
		@Override
		@RosettaAttribute("businessCenter")
		public BusinessCenter getBusinessCenter() {
			return businessCenter;
		}
		
		@Override
		public ExerciseNotice build() {
			return this;
		}
		
		@Override
		public ExerciseNotice.ExerciseNoticeBuilder toBuilder() {
			ExerciseNotice.ExerciseNoticeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ExerciseNotice.ExerciseNoticeBuilder builder) {
			ofNullable(getPartyReference()).ifPresent(builder::setPartyReference);
			ofNullable(getExerciseNoticePartyReference()).ifPresent(builder::setExerciseNoticePartyReference);
			ofNullable(getBusinessCenter()).ifPresent(builder::setBusinessCenter);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExerciseNotice _that = getType().cast(o);
		
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			if (!Objects.equals(exerciseNoticePartyReference, _that.getExerciseNoticePartyReference())) return false;
			if (!Objects.equals(businessCenter, _that.getBusinessCenter())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			_result = 31 * _result + (exerciseNoticePartyReference != null ? exerciseNoticePartyReference.hashCode() : 0);
			_result = 31 * _result + (businessCenter != null ? businessCenter.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExerciseNotice {" +
				"partyReference=" + this.partyReference + ", " +
				"exerciseNoticePartyReference=" + this.exerciseNoticePartyReference + ", " +
				"businessCenter=" + this.businessCenter +
			'}';
		}
	}

	/*********************** Builder Implementation of ExerciseNotice  ***********************/
	class ExerciseNoticeBuilderImpl implements ExerciseNotice.ExerciseNoticeBuilder {
	
		protected PartyReference.PartyReferenceBuilder partyReference;
		protected PartyReference.PartyReferenceBuilder exerciseNoticePartyReference;
		protected BusinessCenter.BusinessCenterBuilder businessCenter;
	
		public ExerciseNoticeBuilderImpl() {
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
		@RosettaAttribute("exerciseNoticePartyReference")
		public PartyReference.PartyReferenceBuilder getExerciseNoticePartyReference() {
			return exerciseNoticePartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateExerciseNoticePartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (exerciseNoticePartyReference!=null) {
				result = exerciseNoticePartyReference;
			}
			else {
				result = exerciseNoticePartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("businessCenter")
		public BusinessCenter.BusinessCenterBuilder getBusinessCenter() {
			return businessCenter;
		}
		
		@Override
		public BusinessCenter.BusinessCenterBuilder getOrCreateBusinessCenter() {
			BusinessCenter.BusinessCenterBuilder result;
			if (businessCenter!=null) {
				result = businessCenter;
			}
			else {
				result = businessCenter = BusinessCenter.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("partyReference")
		public ExerciseNotice.ExerciseNoticeBuilder setPartyReference(PartyReference partyReference) {
			this.partyReference = partyReference==null?null:partyReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exerciseNoticePartyReference")
		public ExerciseNotice.ExerciseNoticeBuilder setExerciseNoticePartyReference(PartyReference exerciseNoticePartyReference) {
			this.exerciseNoticePartyReference = exerciseNoticePartyReference==null?null:exerciseNoticePartyReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("businessCenter")
		public ExerciseNotice.ExerciseNoticeBuilder setBusinessCenter(BusinessCenter businessCenter) {
			this.businessCenter = businessCenter==null?null:businessCenter.toBuilder();
			return this;
		}
		
		@Override
		public ExerciseNotice build() {
			return new ExerciseNotice.ExerciseNoticeImpl(this);
		}
		
		@Override
		public ExerciseNotice.ExerciseNoticeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExerciseNotice.ExerciseNoticeBuilder prune() {
			if (partyReference!=null && !partyReference.prune().hasData()) partyReference = null;
			if (exerciseNoticePartyReference!=null && !exerciseNoticePartyReference.prune().hasData()) exerciseNoticePartyReference = null;
			if (businessCenter!=null && !businessCenter.prune().hasData()) businessCenter = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPartyReference()!=null && getPartyReference().hasData()) return true;
			if (getExerciseNoticePartyReference()!=null && getExerciseNoticePartyReference().hasData()) return true;
			if (getBusinessCenter()!=null && getBusinessCenter().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExerciseNotice.ExerciseNoticeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ExerciseNotice.ExerciseNoticeBuilder o = (ExerciseNotice.ExerciseNoticeBuilder) other;
			
			merger.mergeRosetta(getPartyReference(), o.getPartyReference(), this::setPartyReference);
			merger.mergeRosetta(getExerciseNoticePartyReference(), o.getExerciseNoticePartyReference(), this::setExerciseNoticePartyReference);
			merger.mergeRosetta(getBusinessCenter(), o.getBusinessCenter(), this::setBusinessCenter);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExerciseNotice _that = getType().cast(o);
		
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			if (!Objects.equals(exerciseNoticePartyReference, _that.getExerciseNoticePartyReference())) return false;
			if (!Objects.equals(businessCenter, _that.getBusinessCenter())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			_result = 31 * _result + (exerciseNoticePartyReference != null ? exerciseNoticePartyReference.hashCode() : 0);
			_result = 31 * _result + (businessCenter != null ? businessCenter.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExerciseNoticeBuilder {" +
				"partyReference=" + this.partyReference + ", " +
				"exerciseNoticePartyReference=" + this.exerciseNoticePartyReference + ", " +
				"businessCenter=" + this.businessCenter +
			'}';
		}
	}
}
