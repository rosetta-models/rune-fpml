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
import fpml.confirmation.FxCoreDetailsModelSequence;
import fpml.confirmation.FxCoreDetailsModelSequence.FxCoreDetailsModelSequenceBuilder;
import fpml.confirmation.FxCoreDetailsModelSequence.FxCoreDetailsModelSequenceBuilderImpl;
import fpml.confirmation.FxCoreDetailsModelSequence.FxCoreDetailsModelSequenceImpl;
import fpml.confirmation.meta.FxCoreDetailsModelSequenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="FxCoreDetailsModelSequence", builder=FxCoreDetailsModelSequence.FxCoreDetailsModelSequenceBuilderImpl.class, version="${project.version}")
public interface FxCoreDetailsModelSequence extends RosettaModelObject {

	FxCoreDetailsModelSequenceMeta metaData = new FxCoreDetailsModelSequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The date on which the currency1 amount will be settled. To be used in a split value date scenario.
	 */
	Date getCurrency1ValueDate();
	/**
	 * The date on which the currency2 amount will be settled. To be used in a split value date scenario.
	 */
	Date getCurrency2ValueDate();

	/*********************** Build Methods  ***********************/
	FxCoreDetailsModelSequence build();
	
	FxCoreDetailsModelSequence.FxCoreDetailsModelSequenceBuilder toBuilder();
	
	static FxCoreDetailsModelSequence.FxCoreDetailsModelSequenceBuilder builder() {
		return new FxCoreDetailsModelSequence.FxCoreDetailsModelSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxCoreDetailsModelSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxCoreDetailsModelSequence> getType() {
		return FxCoreDetailsModelSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("currency1ValueDate"), Date.class, getCurrency1ValueDate(), this);
		processor.processBasic(path.newSubPath("currency2ValueDate"), Date.class, getCurrency2ValueDate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxCoreDetailsModelSequenceBuilder extends FxCoreDetailsModelSequence, RosettaModelObjectBuilder {
		FxCoreDetailsModelSequence.FxCoreDetailsModelSequenceBuilder setCurrency1ValueDate(Date currency1ValueDate);
		FxCoreDetailsModelSequence.FxCoreDetailsModelSequenceBuilder setCurrency2ValueDate(Date currency2ValueDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("currency1ValueDate"), Date.class, getCurrency1ValueDate(), this);
			processor.processBasic(path.newSubPath("currency2ValueDate"), Date.class, getCurrency2ValueDate(), this);
		}
		

		FxCoreDetailsModelSequence.FxCoreDetailsModelSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of FxCoreDetailsModelSequence  ***********************/
	class FxCoreDetailsModelSequenceImpl implements FxCoreDetailsModelSequence {
		private final Date currency1ValueDate;
		private final Date currency2ValueDate;
		
		protected FxCoreDetailsModelSequenceImpl(FxCoreDetailsModelSequence.FxCoreDetailsModelSequenceBuilder builder) {
			this.currency1ValueDate = builder.getCurrency1ValueDate();
			this.currency2ValueDate = builder.getCurrency2ValueDate();
		}
		
		@Override
		@RosettaAttribute("currency1ValueDate")
		public Date getCurrency1ValueDate() {
			return currency1ValueDate;
		}
		
		@Override
		@RosettaAttribute("currency2ValueDate")
		public Date getCurrency2ValueDate() {
			return currency2ValueDate;
		}
		
		@Override
		public FxCoreDetailsModelSequence build() {
			return this;
		}
		
		@Override
		public FxCoreDetailsModelSequence.FxCoreDetailsModelSequenceBuilder toBuilder() {
			FxCoreDetailsModelSequence.FxCoreDetailsModelSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxCoreDetailsModelSequence.FxCoreDetailsModelSequenceBuilder builder) {
			ofNullable(getCurrency1ValueDate()).ifPresent(builder::setCurrency1ValueDate);
			ofNullable(getCurrency2ValueDate()).ifPresent(builder::setCurrency2ValueDate);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxCoreDetailsModelSequence _that = getType().cast(o);
		
			if (!Objects.equals(currency1ValueDate, _that.getCurrency1ValueDate())) return false;
			if (!Objects.equals(currency2ValueDate, _that.getCurrency2ValueDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (currency1ValueDate != null ? currency1ValueDate.hashCode() : 0);
			_result = 31 * _result + (currency2ValueDate != null ? currency2ValueDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxCoreDetailsModelSequence {" +
				"currency1ValueDate=" + this.currency1ValueDate + ", " +
				"currency2ValueDate=" + this.currency2ValueDate +
			'}';
		}
	}

	/*********************** Builder Implementation of FxCoreDetailsModelSequence  ***********************/
	class FxCoreDetailsModelSequenceBuilderImpl implements FxCoreDetailsModelSequence.FxCoreDetailsModelSequenceBuilder {
	
		protected Date currency1ValueDate;
		protected Date currency2ValueDate;
	
		public FxCoreDetailsModelSequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("currency1ValueDate")
		public Date getCurrency1ValueDate() {
			return currency1ValueDate;
		}
		
		@Override
		@RosettaAttribute("currency2ValueDate")
		public Date getCurrency2ValueDate() {
			return currency2ValueDate;
		}
		
		@Override
		@RosettaAttribute("currency1ValueDate")
		public FxCoreDetailsModelSequence.FxCoreDetailsModelSequenceBuilder setCurrency1ValueDate(Date currency1ValueDate) {
			this.currency1ValueDate = currency1ValueDate==null?null:currency1ValueDate;
			return this;
		}
		@Override
		@RosettaAttribute("currency2ValueDate")
		public FxCoreDetailsModelSequence.FxCoreDetailsModelSequenceBuilder setCurrency2ValueDate(Date currency2ValueDate) {
			this.currency2ValueDate = currency2ValueDate==null?null:currency2ValueDate;
			return this;
		}
		
		@Override
		public FxCoreDetailsModelSequence build() {
			return new FxCoreDetailsModelSequence.FxCoreDetailsModelSequenceImpl(this);
		}
		
		@Override
		public FxCoreDetailsModelSequence.FxCoreDetailsModelSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxCoreDetailsModelSequence.FxCoreDetailsModelSequenceBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCurrency1ValueDate()!=null) return true;
			if (getCurrency2ValueDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxCoreDetailsModelSequence.FxCoreDetailsModelSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxCoreDetailsModelSequence.FxCoreDetailsModelSequenceBuilder o = (FxCoreDetailsModelSequence.FxCoreDetailsModelSequenceBuilder) other;
			
			
			merger.mergeBasic(getCurrency1ValueDate(), o.getCurrency1ValueDate(), this::setCurrency1ValueDate);
			merger.mergeBasic(getCurrency2ValueDate(), o.getCurrency2ValueDate(), this::setCurrency2ValueDate);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxCoreDetailsModelSequence _that = getType().cast(o);
		
			if (!Objects.equals(currency1ValueDate, _that.getCurrency1ValueDate())) return false;
			if (!Objects.equals(currency2ValueDate, _that.getCurrency2ValueDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (currency1ValueDate != null ? currency1ValueDate.hashCode() : 0);
			_result = 31 * _result + (currency2ValueDate != null ? currency2ValueDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxCoreDetailsModelSequenceBuilder {" +
				"currency1ValueDate=" + this.currency1ValueDate + ", " +
				"currency2ValueDate=" + this.currency2ValueDate +
			'}';
		}
	}
}
