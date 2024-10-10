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
import fpml.confirmation.AdjustableOffset;
import fpml.confirmation.PartyNoticePeriod;
import fpml.confirmation.PartyNoticePeriod.PartyNoticePeriodBuilder;
import fpml.confirmation.PartyNoticePeriod.PartyNoticePeriodBuilderImpl;
import fpml.confirmation.PartyNoticePeriod.PartyNoticePeriodImpl;
import fpml.confirmation.PartyReference;
import fpml.confirmation.meta.PartyNoticePeriodMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type to represent agreed period of notice to be given in advance before exercise of the open repo trade by a party requesting such exercise and reference to that party.
 * @version ${project.version}
 */
@RosettaDataType(value="PartyNoticePeriod", builder=PartyNoticePeriod.PartyNoticePeriodBuilderImpl.class, version="${project.version}")
public interface PartyNoticePeriod extends RosettaModelObject {

	PartyNoticePeriodMeta metaData = new PartyNoticePeriodMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A reference to a party who has the right to request exercise of the open repo trade and for whom noticePeriod is defined.
	 */
	PartyReference getPartyReference();
	/**
	 * Notice period for open repo transactions in number of days. This element represents agreed period of notice to be given in advance before exercise of the repo trade by a party requesting such exercise.
	 */
	AdjustableOffset getNoticePeriod();

	/*********************** Build Methods  ***********************/
	PartyNoticePeriod build();
	
	PartyNoticePeriod.PartyNoticePeriodBuilder toBuilder();
	
	static PartyNoticePeriod.PartyNoticePeriodBuilder builder() {
		return new PartyNoticePeriod.PartyNoticePeriodBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PartyNoticePeriod> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PartyNoticePeriod> getType() {
		return PartyNoticePeriod.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("partyReference"), processor, PartyReference.class, getPartyReference());
		processRosetta(path.newSubPath("noticePeriod"), processor, AdjustableOffset.class, getNoticePeriod());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PartyNoticePeriodBuilder extends PartyNoticePeriod, RosettaModelObjectBuilder {
		PartyReference.PartyReferenceBuilder getOrCreatePartyReference();
		PartyReference.PartyReferenceBuilder getPartyReference();
		AdjustableOffset.AdjustableOffsetBuilder getOrCreateNoticePeriod();
		AdjustableOffset.AdjustableOffsetBuilder getNoticePeriod();
		PartyNoticePeriod.PartyNoticePeriodBuilder setPartyReference(PartyReference partyReference);
		PartyNoticePeriod.PartyNoticePeriodBuilder setNoticePeriod(AdjustableOffset noticePeriod);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("partyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPartyReference());
			processRosetta(path.newSubPath("noticePeriod"), processor, AdjustableOffset.AdjustableOffsetBuilder.class, getNoticePeriod());
		}
		

		PartyNoticePeriod.PartyNoticePeriodBuilder prune();
	}

	/*********************** Immutable Implementation of PartyNoticePeriod  ***********************/
	class PartyNoticePeriodImpl implements PartyNoticePeriod {
		private final PartyReference partyReference;
		private final AdjustableOffset noticePeriod;
		
		protected PartyNoticePeriodImpl(PartyNoticePeriod.PartyNoticePeriodBuilder builder) {
			this.partyReference = ofNullable(builder.getPartyReference()).map(f->f.build()).orElse(null);
			this.noticePeriod = ofNullable(builder.getNoticePeriod()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("partyReference")
		public PartyReference getPartyReference() {
			return partyReference;
		}
		
		@Override
		@RosettaAttribute("noticePeriod")
		public AdjustableOffset getNoticePeriod() {
			return noticePeriod;
		}
		
		@Override
		public PartyNoticePeriod build() {
			return this;
		}
		
		@Override
		public PartyNoticePeriod.PartyNoticePeriodBuilder toBuilder() {
			PartyNoticePeriod.PartyNoticePeriodBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PartyNoticePeriod.PartyNoticePeriodBuilder builder) {
			ofNullable(getPartyReference()).ifPresent(builder::setPartyReference);
			ofNullable(getNoticePeriod()).ifPresent(builder::setNoticePeriod);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyNoticePeriod _that = getType().cast(o);
		
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			if (!Objects.equals(noticePeriod, _that.getNoticePeriod())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			_result = 31 * _result + (noticePeriod != null ? noticePeriod.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyNoticePeriod {" +
				"partyReference=" + this.partyReference + ", " +
				"noticePeriod=" + this.noticePeriod +
			'}';
		}
	}

	/*********************** Builder Implementation of PartyNoticePeriod  ***********************/
	class PartyNoticePeriodBuilderImpl implements PartyNoticePeriod.PartyNoticePeriodBuilder {
	
		protected PartyReference.PartyReferenceBuilder partyReference;
		protected AdjustableOffset.AdjustableOffsetBuilder noticePeriod;
	
		public PartyNoticePeriodBuilderImpl() {
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
		@RosettaAttribute("noticePeriod")
		public AdjustableOffset.AdjustableOffsetBuilder getNoticePeriod() {
			return noticePeriod;
		}
		
		@Override
		public AdjustableOffset.AdjustableOffsetBuilder getOrCreateNoticePeriod() {
			AdjustableOffset.AdjustableOffsetBuilder result;
			if (noticePeriod!=null) {
				result = noticePeriod;
			}
			else {
				result = noticePeriod = AdjustableOffset.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("partyReference")
		public PartyNoticePeriod.PartyNoticePeriodBuilder setPartyReference(PartyReference partyReference) {
			this.partyReference = partyReference==null?null:partyReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("noticePeriod")
		public PartyNoticePeriod.PartyNoticePeriodBuilder setNoticePeriod(AdjustableOffset noticePeriod) {
			this.noticePeriod = noticePeriod==null?null:noticePeriod.toBuilder();
			return this;
		}
		
		@Override
		public PartyNoticePeriod build() {
			return new PartyNoticePeriod.PartyNoticePeriodImpl(this);
		}
		
		@Override
		public PartyNoticePeriod.PartyNoticePeriodBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyNoticePeriod.PartyNoticePeriodBuilder prune() {
			if (partyReference!=null && !partyReference.prune().hasData()) partyReference = null;
			if (noticePeriod!=null && !noticePeriod.prune().hasData()) noticePeriod = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPartyReference()!=null && getPartyReference().hasData()) return true;
			if (getNoticePeriod()!=null && getNoticePeriod().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyNoticePeriod.PartyNoticePeriodBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PartyNoticePeriod.PartyNoticePeriodBuilder o = (PartyNoticePeriod.PartyNoticePeriodBuilder) other;
			
			merger.mergeRosetta(getPartyReference(), o.getPartyReference(), this::setPartyReference);
			merger.mergeRosetta(getNoticePeriod(), o.getNoticePeriod(), this::setNoticePeriod);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyNoticePeriod _that = getType().cast(o);
		
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			if (!Objects.equals(noticePeriod, _that.getNoticePeriod())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			_result = 31 * _result + (noticePeriod != null ? noticePeriod.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyNoticePeriodBuilder {" +
				"partyReference=" + this.partyReference + ", " +
				"noticePeriod=" + this.noticePeriod +
			'}';
		}
	}
}
