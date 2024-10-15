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
import fpml.confirmation.AdjustableDate;
import fpml.confirmation.CommodityStartingDate;
import fpml.confirmation.CommodityStartingDate.CommodityStartingDateBuilder;
import fpml.confirmation.CommodityStartingDate.CommodityStartingDateBuilderImpl;
import fpml.confirmation.CommodityStartingDate.CommodityStartingDateImpl;
import fpml.confirmation.PartyReference;
import fpml.confirmation.meta.CommodityStartingDateMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type specifying the date from which the early termination clause can be exercised.
 * @version ${project.version}
 */
@RosettaDataType(value="CommodityStartingDate", builder=CommodityStartingDate.CommodityStartingDateBuilderImpl.class, version="${project.version}")
public interface CommodityStartingDate extends RosettaModelObject {

	CommodityStartingDateMeta metaData = new CommodityStartingDateMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Reference to a party defined elsewhere in this document which may be allowed to terminate the trade.
	 */
	PartyReference getDateRelativeTo();
	/**
	 * Date from which early termination clause can be exercised.
	 */
	AdjustableDate getAdjustableDate();

	/*********************** Build Methods  ***********************/
	CommodityStartingDate build();
	
	CommodityStartingDate.CommodityStartingDateBuilder toBuilder();
	
	static CommodityStartingDate.CommodityStartingDateBuilder builder() {
		return new CommodityStartingDate.CommodityStartingDateBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityStartingDate> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityStartingDate> getType() {
		return CommodityStartingDate.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("dateRelativeTo"), processor, PartyReference.class, getDateRelativeTo());
		processRosetta(path.newSubPath("adjustableDate"), processor, AdjustableDate.class, getAdjustableDate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityStartingDateBuilder extends CommodityStartingDate, RosettaModelObjectBuilder {
		PartyReference.PartyReferenceBuilder getOrCreateDateRelativeTo();
		PartyReference.PartyReferenceBuilder getDateRelativeTo();
		AdjustableDate.AdjustableDateBuilder getOrCreateAdjustableDate();
		AdjustableDate.AdjustableDateBuilder getAdjustableDate();
		CommodityStartingDate.CommodityStartingDateBuilder setDateRelativeTo(PartyReference dateRelativeTo);
		CommodityStartingDate.CommodityStartingDateBuilder setAdjustableDate(AdjustableDate adjustableDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("dateRelativeTo"), processor, PartyReference.PartyReferenceBuilder.class, getDateRelativeTo());
			processRosetta(path.newSubPath("adjustableDate"), processor, AdjustableDate.AdjustableDateBuilder.class, getAdjustableDate());
		}
		

		CommodityStartingDate.CommodityStartingDateBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityStartingDate  ***********************/
	class CommodityStartingDateImpl implements CommodityStartingDate {
		private final PartyReference dateRelativeTo;
		private final AdjustableDate adjustableDate;
		
		protected CommodityStartingDateImpl(CommodityStartingDate.CommodityStartingDateBuilder builder) {
			this.dateRelativeTo = ofNullable(builder.getDateRelativeTo()).map(f->f.build()).orElse(null);
			this.adjustableDate = ofNullable(builder.getAdjustableDate()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("dateRelativeTo")
		public PartyReference getDateRelativeTo() {
			return dateRelativeTo;
		}
		
		@Override
		@RosettaAttribute("adjustableDate")
		public AdjustableDate getAdjustableDate() {
			return adjustableDate;
		}
		
		@Override
		public CommodityStartingDate build() {
			return this;
		}
		
		@Override
		public CommodityStartingDate.CommodityStartingDateBuilder toBuilder() {
			CommodityStartingDate.CommodityStartingDateBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityStartingDate.CommodityStartingDateBuilder builder) {
			ofNullable(getDateRelativeTo()).ifPresent(builder::setDateRelativeTo);
			ofNullable(getAdjustableDate()).ifPresent(builder::setAdjustableDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityStartingDate _that = getType().cast(o);
		
			if (!Objects.equals(dateRelativeTo, _that.getDateRelativeTo())) return false;
			if (!Objects.equals(adjustableDate, _that.getAdjustableDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dateRelativeTo != null ? dateRelativeTo.hashCode() : 0);
			_result = 31 * _result + (adjustableDate != null ? adjustableDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityStartingDate {" +
				"dateRelativeTo=" + this.dateRelativeTo + ", " +
				"adjustableDate=" + this.adjustableDate +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityStartingDate  ***********************/
	class CommodityStartingDateBuilderImpl implements CommodityStartingDate.CommodityStartingDateBuilder {
	
		protected PartyReference.PartyReferenceBuilder dateRelativeTo;
		protected AdjustableDate.AdjustableDateBuilder adjustableDate;
	
		public CommodityStartingDateBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("dateRelativeTo")
		public PartyReference.PartyReferenceBuilder getDateRelativeTo() {
			return dateRelativeTo;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateDateRelativeTo() {
			PartyReference.PartyReferenceBuilder result;
			if (dateRelativeTo!=null) {
				result = dateRelativeTo;
			}
			else {
				result = dateRelativeTo = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("adjustableDate")
		public AdjustableDate.AdjustableDateBuilder getAdjustableDate() {
			return adjustableDate;
		}
		
		@Override
		public AdjustableDate.AdjustableDateBuilder getOrCreateAdjustableDate() {
			AdjustableDate.AdjustableDateBuilder result;
			if (adjustableDate!=null) {
				result = adjustableDate;
			}
			else {
				result = adjustableDate = AdjustableDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("dateRelativeTo")
		public CommodityStartingDate.CommodityStartingDateBuilder setDateRelativeTo(PartyReference dateRelativeTo) {
			this.dateRelativeTo = dateRelativeTo==null?null:dateRelativeTo.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("adjustableDate")
		public CommodityStartingDate.CommodityStartingDateBuilder setAdjustableDate(AdjustableDate adjustableDate) {
			this.adjustableDate = adjustableDate==null?null:adjustableDate.toBuilder();
			return this;
		}
		
		@Override
		public CommodityStartingDate build() {
			return new CommodityStartingDate.CommodityStartingDateImpl(this);
		}
		
		@Override
		public CommodityStartingDate.CommodityStartingDateBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityStartingDate.CommodityStartingDateBuilder prune() {
			if (dateRelativeTo!=null && !dateRelativeTo.prune().hasData()) dateRelativeTo = null;
			if (adjustableDate!=null && !adjustableDate.prune().hasData()) adjustableDate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDateRelativeTo()!=null && getDateRelativeTo().hasData()) return true;
			if (getAdjustableDate()!=null && getAdjustableDate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityStartingDate.CommodityStartingDateBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityStartingDate.CommodityStartingDateBuilder o = (CommodityStartingDate.CommodityStartingDateBuilder) other;
			
			merger.mergeRosetta(getDateRelativeTo(), o.getDateRelativeTo(), this::setDateRelativeTo);
			merger.mergeRosetta(getAdjustableDate(), o.getAdjustableDate(), this::setAdjustableDate);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityStartingDate _that = getType().cast(o);
		
			if (!Objects.equals(dateRelativeTo, _that.getDateRelativeTo())) return false;
			if (!Objects.equals(adjustableDate, _that.getAdjustableDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dateRelativeTo != null ? dateRelativeTo.hashCode() : 0);
			_result = 31 * _result + (adjustableDate != null ? adjustableDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityStartingDateBuilder {" +
				"dateRelativeTo=" + this.dateRelativeTo + ", " +
				"adjustableDate=" + this.adjustableDate +
			'}';
		}
	}
}
