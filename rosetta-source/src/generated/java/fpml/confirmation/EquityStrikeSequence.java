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
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.EquityStrikeSequence;
import fpml.confirmation.EquityStrikeSequence.EquityStrikeSequenceBuilder;
import fpml.confirmation.EquityStrikeSequence.EquityStrikeSequenceBuilderImpl;
import fpml.confirmation.EquityStrikeSequence.EquityStrikeSequenceImpl;
import fpml.confirmation.meta.EquityStrikeSequenceMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="EquityStrikeSequence", builder=EquityStrikeSequence.EquityStrikeSequenceBuilderImpl.class, version="${project.version}")
public interface EquityStrikeSequence extends RosettaModelObject {

	EquityStrikeSequenceMeta metaData = new EquityStrikeSequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The price or level expressed as a percentage of the forward starting spot price.
	 */
	BigDecimal getStrikePercentage();
	/**
	 * The date on which the strike is determined, where this is not the effective date of a forward starting option.
	 */
	AdjustableOrRelativeDate getStrikeDeterminationDate();

	/*********************** Build Methods  ***********************/
	EquityStrikeSequence build();
	
	EquityStrikeSequence.EquityStrikeSequenceBuilder toBuilder();
	
	static EquityStrikeSequence.EquityStrikeSequenceBuilder builder() {
		return new EquityStrikeSequence.EquityStrikeSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EquityStrikeSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends EquityStrikeSequence> getType() {
		return EquityStrikeSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("strikePercentage"), BigDecimal.class, getStrikePercentage(), this);
		processRosetta(path.newSubPath("strikeDeterminationDate"), processor, AdjustableOrRelativeDate.class, getStrikeDeterminationDate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface EquityStrikeSequenceBuilder extends EquityStrikeSequence, RosettaModelObjectBuilder {
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateStrikeDeterminationDate();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getStrikeDeterminationDate();
		EquityStrikeSequence.EquityStrikeSequenceBuilder setStrikePercentage(BigDecimal strikePercentage);
		EquityStrikeSequence.EquityStrikeSequenceBuilder setStrikeDeterminationDate(AdjustableOrRelativeDate strikeDeterminationDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("strikePercentage"), BigDecimal.class, getStrikePercentage(), this);
			processRosetta(path.newSubPath("strikeDeterminationDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getStrikeDeterminationDate());
		}
		

		EquityStrikeSequence.EquityStrikeSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of EquityStrikeSequence  ***********************/
	class EquityStrikeSequenceImpl implements EquityStrikeSequence {
		private final BigDecimal strikePercentage;
		private final AdjustableOrRelativeDate strikeDeterminationDate;
		
		protected EquityStrikeSequenceImpl(EquityStrikeSequence.EquityStrikeSequenceBuilder builder) {
			this.strikePercentage = builder.getStrikePercentage();
			this.strikeDeterminationDate = ofNullable(builder.getStrikeDeterminationDate()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("strikePercentage")
		public BigDecimal getStrikePercentage() {
			return strikePercentage;
		}
		
		@Override
		@RosettaAttribute("strikeDeterminationDate")
		public AdjustableOrRelativeDate getStrikeDeterminationDate() {
			return strikeDeterminationDate;
		}
		
		@Override
		public EquityStrikeSequence build() {
			return this;
		}
		
		@Override
		public EquityStrikeSequence.EquityStrikeSequenceBuilder toBuilder() {
			EquityStrikeSequence.EquityStrikeSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EquityStrikeSequence.EquityStrikeSequenceBuilder builder) {
			ofNullable(getStrikePercentage()).ifPresent(builder::setStrikePercentage);
			ofNullable(getStrikeDeterminationDate()).ifPresent(builder::setStrikeDeterminationDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EquityStrikeSequence _that = getType().cast(o);
		
			if (!Objects.equals(strikePercentage, _that.getStrikePercentage())) return false;
			if (!Objects.equals(strikeDeterminationDate, _that.getStrikeDeterminationDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (strikePercentage != null ? strikePercentage.hashCode() : 0);
			_result = 31 * _result + (strikeDeterminationDate != null ? strikeDeterminationDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EquityStrikeSequence {" +
				"strikePercentage=" + this.strikePercentage + ", " +
				"strikeDeterminationDate=" + this.strikeDeterminationDate +
			'}';
		}
	}

	/*********************** Builder Implementation of EquityStrikeSequence  ***********************/
	class EquityStrikeSequenceBuilderImpl implements EquityStrikeSequence.EquityStrikeSequenceBuilder {
	
		protected BigDecimal strikePercentage;
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder strikeDeterminationDate;
	
		public EquityStrikeSequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("strikePercentage")
		public BigDecimal getStrikePercentage() {
			return strikePercentage;
		}
		
		@Override
		@RosettaAttribute("strikeDeterminationDate")
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getStrikeDeterminationDate() {
			return strikeDeterminationDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateStrikeDeterminationDate() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			if (strikeDeterminationDate!=null) {
				result = strikeDeterminationDate;
			}
			else {
				result = strikeDeterminationDate = AdjustableOrRelativeDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("strikePercentage")
		public EquityStrikeSequence.EquityStrikeSequenceBuilder setStrikePercentage(BigDecimal strikePercentage) {
			this.strikePercentage = strikePercentage==null?null:strikePercentage;
			return this;
		}
		@Override
		@RosettaAttribute("strikeDeterminationDate")
		public EquityStrikeSequence.EquityStrikeSequenceBuilder setStrikeDeterminationDate(AdjustableOrRelativeDate strikeDeterminationDate) {
			this.strikeDeterminationDate = strikeDeterminationDate==null?null:strikeDeterminationDate.toBuilder();
			return this;
		}
		
		@Override
		public EquityStrikeSequence build() {
			return new EquityStrikeSequence.EquityStrikeSequenceImpl(this);
		}
		
		@Override
		public EquityStrikeSequence.EquityStrikeSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EquityStrikeSequence.EquityStrikeSequenceBuilder prune() {
			if (strikeDeterminationDate!=null && !strikeDeterminationDate.prune().hasData()) strikeDeterminationDate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getStrikePercentage()!=null) return true;
			if (getStrikeDeterminationDate()!=null && getStrikeDeterminationDate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EquityStrikeSequence.EquityStrikeSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			EquityStrikeSequence.EquityStrikeSequenceBuilder o = (EquityStrikeSequence.EquityStrikeSequenceBuilder) other;
			
			merger.mergeRosetta(getStrikeDeterminationDate(), o.getStrikeDeterminationDate(), this::setStrikeDeterminationDate);
			
			merger.mergeBasic(getStrikePercentage(), o.getStrikePercentage(), this::setStrikePercentage);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EquityStrikeSequence _that = getType().cast(o);
		
			if (!Objects.equals(strikePercentage, _that.getStrikePercentage())) return false;
			if (!Objects.equals(strikeDeterminationDate, _that.getStrikeDeterminationDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (strikePercentage != null ? strikePercentage.hashCode() : 0);
			_result = 31 * _result + (strikeDeterminationDate != null ? strikeDeterminationDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EquityStrikeSequenceBuilder {" +
				"strikePercentage=" + this.strikePercentage + ", " +
				"strikeDeterminationDate=" + this.strikeDeterminationDate +
			'}';
		}
	}
}
