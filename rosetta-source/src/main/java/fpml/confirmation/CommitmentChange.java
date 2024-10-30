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
import com.rosetta.model.lib.records.Date;
import fpml.confirmation.AdjustmentType;
import fpml.confirmation.CommitmentChange;
import fpml.confirmation.CommitmentChange.CommitmentChangeBuilder;
import fpml.confirmation.CommitmentChange.CommitmentChangeBuilderImpl;
import fpml.confirmation.CommitmentChange.CommitmentChangeImpl;
import fpml.confirmation.MoneyWithParticipantShare;
import fpml.confirmation.meta.CommitmentChangeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A structure which specifies the commitment changes occurring throughout the life of a facility.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="CommitmentChange", builder=CommitmentChange.CommitmentChangeBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface CommitmentChange extends RosettaModelObject {

	CommitmentChangeMeta metaData = new CommitmentChangeMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The date on which a facility increase/decrease has/will occur.
	 */
	Date getDate();
	/**
	 * The total remaining commitment amount (in facility currency), once the adjustnment has been applied.
	 */
	AdjustmentType getAdjustment();
	/**
	 * The total remaining commitment amount (in facility currency), once the adjustnment has been applied.
	 */
	MoneyWithParticipantShare getRemaining();

	/*********************** Build Methods  ***********************/
	CommitmentChange build();
	
	CommitmentChange.CommitmentChangeBuilder toBuilder();
	
	static CommitmentChange.CommitmentChangeBuilder builder() {
		return new CommitmentChange.CommitmentChangeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommitmentChange> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommitmentChange> getType() {
		return CommitmentChange.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("date"), Date.class, getDate(), this);
		processRosetta(path.newSubPath("adjustment"), processor, AdjustmentType.class, getAdjustment());
		processRosetta(path.newSubPath("remaining"), processor, MoneyWithParticipantShare.class, getRemaining());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommitmentChangeBuilder extends CommitmentChange, RosettaModelObjectBuilder {
		AdjustmentType.AdjustmentTypeBuilder getOrCreateAdjustment();
		AdjustmentType.AdjustmentTypeBuilder getAdjustment();
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOrCreateRemaining();
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getRemaining();
		CommitmentChange.CommitmentChangeBuilder setDate(Date date);
		CommitmentChange.CommitmentChangeBuilder setAdjustment(AdjustmentType adjustment);
		CommitmentChange.CommitmentChangeBuilder setRemaining(MoneyWithParticipantShare remaining);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("date"), Date.class, getDate(), this);
			processRosetta(path.newSubPath("adjustment"), processor, AdjustmentType.AdjustmentTypeBuilder.class, getAdjustment());
			processRosetta(path.newSubPath("remaining"), processor, MoneyWithParticipantShare.MoneyWithParticipantShareBuilder.class, getRemaining());
		}
		

		CommitmentChange.CommitmentChangeBuilder prune();
	}

	/*********************** Immutable Implementation of CommitmentChange  ***********************/
	class CommitmentChangeImpl implements CommitmentChange {
		private final Date date;
		private final AdjustmentType adjustment;
		private final MoneyWithParticipantShare remaining;
		
		protected CommitmentChangeImpl(CommitmentChange.CommitmentChangeBuilder builder) {
			this.date = builder.getDate();
			this.adjustment = ofNullable(builder.getAdjustment()).map(f->f.build()).orElse(null);
			this.remaining = ofNullable(builder.getRemaining()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("date")
		public Date getDate() {
			return date;
		}
		
		@Override
		@RosettaAttribute("adjustment")
		public AdjustmentType getAdjustment() {
			return adjustment;
		}
		
		@Override
		@RosettaAttribute("remaining")
		public MoneyWithParticipantShare getRemaining() {
			return remaining;
		}
		
		@Override
		public CommitmentChange build() {
			return this;
		}
		
		@Override
		public CommitmentChange.CommitmentChangeBuilder toBuilder() {
			CommitmentChange.CommitmentChangeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommitmentChange.CommitmentChangeBuilder builder) {
			ofNullable(getDate()).ifPresent(builder::setDate);
			ofNullable(getAdjustment()).ifPresent(builder::setAdjustment);
			ofNullable(getRemaining()).ifPresent(builder::setRemaining);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommitmentChange _that = getType().cast(o);
		
			if (!Objects.equals(date, _that.getDate())) return false;
			if (!Objects.equals(adjustment, _that.getAdjustment())) return false;
			if (!Objects.equals(remaining, _that.getRemaining())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (date != null ? date.hashCode() : 0);
			_result = 31 * _result + (adjustment != null ? adjustment.hashCode() : 0);
			_result = 31 * _result + (remaining != null ? remaining.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommitmentChange {" +
				"date=" + this.date + ", " +
				"adjustment=" + this.adjustment + ", " +
				"remaining=" + this.remaining +
			'}';
		}
	}

	/*********************** Builder Implementation of CommitmentChange  ***********************/
	class CommitmentChangeBuilderImpl implements CommitmentChange.CommitmentChangeBuilder {
	
		protected Date date;
		protected AdjustmentType.AdjustmentTypeBuilder adjustment;
		protected MoneyWithParticipantShare.MoneyWithParticipantShareBuilder remaining;
	
		public CommitmentChangeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("date")
		public Date getDate() {
			return date;
		}
		
		@Override
		@RosettaAttribute("adjustment")
		public AdjustmentType.AdjustmentTypeBuilder getAdjustment() {
			return adjustment;
		}
		
		@Override
		public AdjustmentType.AdjustmentTypeBuilder getOrCreateAdjustment() {
			AdjustmentType.AdjustmentTypeBuilder result;
			if (adjustment!=null) {
				result = adjustment;
			}
			else {
				result = adjustment = AdjustmentType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("remaining")
		public MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getRemaining() {
			return remaining;
		}
		
		@Override
		public MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOrCreateRemaining() {
			MoneyWithParticipantShare.MoneyWithParticipantShareBuilder result;
			if (remaining!=null) {
				result = remaining;
			}
			else {
				result = remaining = MoneyWithParticipantShare.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("date")
		public CommitmentChange.CommitmentChangeBuilder setDate(Date date) {
			this.date = date==null?null:date;
			return this;
		}
		@Override
		@RosettaAttribute("adjustment")
		public CommitmentChange.CommitmentChangeBuilder setAdjustment(AdjustmentType adjustment) {
			this.adjustment = adjustment==null?null:adjustment.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("remaining")
		public CommitmentChange.CommitmentChangeBuilder setRemaining(MoneyWithParticipantShare remaining) {
			this.remaining = remaining==null?null:remaining.toBuilder();
			return this;
		}
		
		@Override
		public CommitmentChange build() {
			return new CommitmentChange.CommitmentChangeImpl(this);
		}
		
		@Override
		public CommitmentChange.CommitmentChangeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommitmentChange.CommitmentChangeBuilder prune() {
			if (adjustment!=null && !adjustment.prune().hasData()) adjustment = null;
			if (remaining!=null && !remaining.prune().hasData()) remaining = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDate()!=null) return true;
			if (getAdjustment()!=null && getAdjustment().hasData()) return true;
			if (getRemaining()!=null && getRemaining().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommitmentChange.CommitmentChangeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommitmentChange.CommitmentChangeBuilder o = (CommitmentChange.CommitmentChangeBuilder) other;
			
			merger.mergeRosetta(getAdjustment(), o.getAdjustment(), this::setAdjustment);
			merger.mergeRosetta(getRemaining(), o.getRemaining(), this::setRemaining);
			
			merger.mergeBasic(getDate(), o.getDate(), this::setDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommitmentChange _that = getType().cast(o);
		
			if (!Objects.equals(date, _that.getDate())) return false;
			if (!Objects.equals(adjustment, _that.getAdjustment())) return false;
			if (!Objects.equals(remaining, _that.getRemaining())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (date != null ? date.hashCode() : 0);
			_result = 31 * _result + (adjustment != null ? adjustment.hashCode() : 0);
			_result = 31 * _result + (remaining != null ? remaining.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommitmentChangeBuilder {" +
				"date=" + this.date + ", " +
				"adjustment=" + this.adjustment + ", " +
				"remaining=" + this.remaining +
			'}';
		}
	}
}
