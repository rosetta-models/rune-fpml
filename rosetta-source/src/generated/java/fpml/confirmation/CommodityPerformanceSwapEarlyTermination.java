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
import fpml.confirmation.CommodityPerformanceSwapEarlyTermination;
import fpml.confirmation.CommodityPerformanceSwapEarlyTermination.CommodityPerformanceSwapEarlyTerminationBuilder;
import fpml.confirmation.CommodityPerformanceSwapEarlyTermination.CommodityPerformanceSwapEarlyTerminationBuilderImpl;
import fpml.confirmation.CommodityPerformanceSwapEarlyTermination.CommodityPerformanceSwapEarlyTerminationImpl;
import fpml.confirmation.CommodityStartingDate;
import fpml.confirmation.PartyReference;
import fpml.confirmation.meta.CommodityPerformanceSwapEarlyTerminationMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="CommodityPerformanceSwapEarlyTermination", builder=CommodityPerformanceSwapEarlyTermination.CommodityPerformanceSwapEarlyTerminationBuilderImpl.class, version="${project.version}")
public interface CommodityPerformanceSwapEarlyTermination extends RosettaModelObject {

	CommodityPerformanceSwapEarlyTerminationMeta metaData = new CommodityPerformanceSwapEarlyTerminationMeta();

	/*********************** Getter Methods  ***********************/
	PartyReference getPartyReference();
	CommodityStartingDate getStartingDate();

	/*********************** Build Methods  ***********************/
	CommodityPerformanceSwapEarlyTermination build();
	
	CommodityPerformanceSwapEarlyTermination.CommodityPerformanceSwapEarlyTerminationBuilder toBuilder();
	
	static CommodityPerformanceSwapEarlyTermination.CommodityPerformanceSwapEarlyTerminationBuilder builder() {
		return new CommodityPerformanceSwapEarlyTermination.CommodityPerformanceSwapEarlyTerminationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityPerformanceSwapEarlyTermination> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityPerformanceSwapEarlyTermination> getType() {
		return CommodityPerformanceSwapEarlyTermination.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("partyReference"), processor, PartyReference.class, getPartyReference());
		processRosetta(path.newSubPath("startingDate"), processor, CommodityStartingDate.class, getStartingDate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityPerformanceSwapEarlyTerminationBuilder extends CommodityPerformanceSwapEarlyTermination, RosettaModelObjectBuilder {
		PartyReference.PartyReferenceBuilder getOrCreatePartyReference();
		PartyReference.PartyReferenceBuilder getPartyReference();
		CommodityStartingDate.CommodityStartingDateBuilder getOrCreateStartingDate();
		CommodityStartingDate.CommodityStartingDateBuilder getStartingDate();
		CommodityPerformanceSwapEarlyTermination.CommodityPerformanceSwapEarlyTerminationBuilder setPartyReference(PartyReference partyReference);
		CommodityPerformanceSwapEarlyTermination.CommodityPerformanceSwapEarlyTerminationBuilder setStartingDate(CommodityStartingDate startingDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("partyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPartyReference());
			processRosetta(path.newSubPath("startingDate"), processor, CommodityStartingDate.CommodityStartingDateBuilder.class, getStartingDate());
		}
		

		CommodityPerformanceSwapEarlyTermination.CommodityPerformanceSwapEarlyTerminationBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityPerformanceSwapEarlyTermination  ***********************/
	class CommodityPerformanceSwapEarlyTerminationImpl implements CommodityPerformanceSwapEarlyTermination {
		private final PartyReference partyReference;
		private final CommodityStartingDate startingDate;
		
		protected CommodityPerformanceSwapEarlyTerminationImpl(CommodityPerformanceSwapEarlyTermination.CommodityPerformanceSwapEarlyTerminationBuilder builder) {
			this.partyReference = ofNullable(builder.getPartyReference()).map(f->f.build()).orElse(null);
			this.startingDate = ofNullable(builder.getStartingDate()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("partyReference")
		public PartyReference getPartyReference() {
			return partyReference;
		}
		
		@Override
		@RosettaAttribute("startingDate")
		public CommodityStartingDate getStartingDate() {
			return startingDate;
		}
		
		@Override
		public CommodityPerformanceSwapEarlyTermination build() {
			return this;
		}
		
		@Override
		public CommodityPerformanceSwapEarlyTermination.CommodityPerformanceSwapEarlyTerminationBuilder toBuilder() {
			CommodityPerformanceSwapEarlyTermination.CommodityPerformanceSwapEarlyTerminationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityPerformanceSwapEarlyTermination.CommodityPerformanceSwapEarlyTerminationBuilder builder) {
			ofNullable(getPartyReference()).ifPresent(builder::setPartyReference);
			ofNullable(getStartingDate()).ifPresent(builder::setStartingDate);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityPerformanceSwapEarlyTermination _that = getType().cast(o);
		
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			if (!Objects.equals(startingDate, _that.getStartingDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			_result = 31 * _result + (startingDate != null ? startingDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityPerformanceSwapEarlyTermination {" +
				"partyReference=" + this.partyReference + ", " +
				"startingDate=" + this.startingDate +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityPerformanceSwapEarlyTermination  ***********************/
	class CommodityPerformanceSwapEarlyTerminationBuilderImpl implements CommodityPerformanceSwapEarlyTermination.CommodityPerformanceSwapEarlyTerminationBuilder {
	
		protected PartyReference.PartyReferenceBuilder partyReference;
		protected CommodityStartingDate.CommodityStartingDateBuilder startingDate;
	
		public CommodityPerformanceSwapEarlyTerminationBuilderImpl() {
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
		@RosettaAttribute("startingDate")
		public CommodityStartingDate.CommodityStartingDateBuilder getStartingDate() {
			return startingDate;
		}
		
		@Override
		public CommodityStartingDate.CommodityStartingDateBuilder getOrCreateStartingDate() {
			CommodityStartingDate.CommodityStartingDateBuilder result;
			if (startingDate!=null) {
				result = startingDate;
			}
			else {
				result = startingDate = CommodityStartingDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("partyReference")
		public CommodityPerformanceSwapEarlyTermination.CommodityPerformanceSwapEarlyTerminationBuilder setPartyReference(PartyReference partyReference) {
			this.partyReference = partyReference==null?null:partyReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("startingDate")
		public CommodityPerformanceSwapEarlyTermination.CommodityPerformanceSwapEarlyTerminationBuilder setStartingDate(CommodityStartingDate startingDate) {
			this.startingDate = startingDate==null?null:startingDate.toBuilder();
			return this;
		}
		
		@Override
		public CommodityPerformanceSwapEarlyTermination build() {
			return new CommodityPerformanceSwapEarlyTermination.CommodityPerformanceSwapEarlyTerminationImpl(this);
		}
		
		@Override
		public CommodityPerformanceSwapEarlyTermination.CommodityPerformanceSwapEarlyTerminationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityPerformanceSwapEarlyTermination.CommodityPerformanceSwapEarlyTerminationBuilder prune() {
			if (partyReference!=null && !partyReference.prune().hasData()) partyReference = null;
			if (startingDate!=null && !startingDate.prune().hasData()) startingDate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPartyReference()!=null && getPartyReference().hasData()) return true;
			if (getStartingDate()!=null && getStartingDate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityPerformanceSwapEarlyTermination.CommodityPerformanceSwapEarlyTerminationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityPerformanceSwapEarlyTermination.CommodityPerformanceSwapEarlyTerminationBuilder o = (CommodityPerformanceSwapEarlyTermination.CommodityPerformanceSwapEarlyTerminationBuilder) other;
			
			merger.mergeRosetta(getPartyReference(), o.getPartyReference(), this::setPartyReference);
			merger.mergeRosetta(getStartingDate(), o.getStartingDate(), this::setStartingDate);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityPerformanceSwapEarlyTermination _that = getType().cast(o);
		
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			if (!Objects.equals(startingDate, _that.getStartingDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			_result = 31 * _result + (startingDate != null ? startingDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityPerformanceSwapEarlyTerminationBuilder {" +
				"partyReference=" + this.partyReference + ", " +
				"startingDate=" + this.startingDate +
			'}';
		}
	}
}
