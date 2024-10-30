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
import fpml.confirmation.EnvironmentalProductComplaincePeriod;
import fpml.confirmation.EnvironmentalProductComplaincePeriod.EnvironmentalProductComplaincePeriodBuilder;
import fpml.confirmation.EnvironmentalProductComplaincePeriod.EnvironmentalProductComplaincePeriodBuilderImpl;
import fpml.confirmation.EnvironmentalProductComplaincePeriod.EnvironmentalProductComplaincePeriodImpl;
import fpml.confirmation.meta.EnvironmentalProductComplaincePeriodMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="EnvironmentalProductComplaincePeriod", builder=EnvironmentalProductComplaincePeriod.EnvironmentalProductComplaincePeriodBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface EnvironmentalProductComplaincePeriod extends RosettaModelObject {

	EnvironmentalProductComplaincePeriodMeta metaData = new EnvironmentalProductComplaincePeriodMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The first year of the Compliance Period.
	 */
	Integer getStartYear();
	/**
	 * The last year of the Commpliance Period.
	 */
	Integer getEndYear();

	/*********************** Build Methods  ***********************/
	EnvironmentalProductComplaincePeriod build();
	
	EnvironmentalProductComplaincePeriod.EnvironmentalProductComplaincePeriodBuilder toBuilder();
	
	static EnvironmentalProductComplaincePeriod.EnvironmentalProductComplaincePeriodBuilder builder() {
		return new EnvironmentalProductComplaincePeriod.EnvironmentalProductComplaincePeriodBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EnvironmentalProductComplaincePeriod> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends EnvironmentalProductComplaincePeriod> getType() {
		return EnvironmentalProductComplaincePeriod.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("startYear"), Integer.class, getStartYear(), this);
		processor.processBasic(path.newSubPath("endYear"), Integer.class, getEndYear(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface EnvironmentalProductComplaincePeriodBuilder extends EnvironmentalProductComplaincePeriod, RosettaModelObjectBuilder {
		EnvironmentalProductComplaincePeriod.EnvironmentalProductComplaincePeriodBuilder setStartYear(Integer startYear);
		EnvironmentalProductComplaincePeriod.EnvironmentalProductComplaincePeriodBuilder setEndYear(Integer endYear);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("startYear"), Integer.class, getStartYear(), this);
			processor.processBasic(path.newSubPath("endYear"), Integer.class, getEndYear(), this);
		}
		

		EnvironmentalProductComplaincePeriod.EnvironmentalProductComplaincePeriodBuilder prune();
	}

	/*********************** Immutable Implementation of EnvironmentalProductComplaincePeriod  ***********************/
	class EnvironmentalProductComplaincePeriodImpl implements EnvironmentalProductComplaincePeriod {
		private final Integer startYear;
		private final Integer endYear;
		
		protected EnvironmentalProductComplaincePeriodImpl(EnvironmentalProductComplaincePeriod.EnvironmentalProductComplaincePeriodBuilder builder) {
			this.startYear = builder.getStartYear();
			this.endYear = builder.getEndYear();
		}
		
		@Override
		@RosettaAttribute("startYear")
		public Integer getStartYear() {
			return startYear;
		}
		
		@Override
		@RosettaAttribute("endYear")
		public Integer getEndYear() {
			return endYear;
		}
		
		@Override
		public EnvironmentalProductComplaincePeriod build() {
			return this;
		}
		
		@Override
		public EnvironmentalProductComplaincePeriod.EnvironmentalProductComplaincePeriodBuilder toBuilder() {
			EnvironmentalProductComplaincePeriod.EnvironmentalProductComplaincePeriodBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EnvironmentalProductComplaincePeriod.EnvironmentalProductComplaincePeriodBuilder builder) {
			ofNullable(getStartYear()).ifPresent(builder::setStartYear);
			ofNullable(getEndYear()).ifPresent(builder::setEndYear);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EnvironmentalProductComplaincePeriod _that = getType().cast(o);
		
			if (!Objects.equals(startYear, _that.getStartYear())) return false;
			if (!Objects.equals(endYear, _that.getEndYear())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (startYear != null ? startYear.hashCode() : 0);
			_result = 31 * _result + (endYear != null ? endYear.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EnvironmentalProductComplaincePeriod {" +
				"startYear=" + this.startYear + ", " +
				"endYear=" + this.endYear +
			'}';
		}
	}

	/*********************** Builder Implementation of EnvironmentalProductComplaincePeriod  ***********************/
	class EnvironmentalProductComplaincePeriodBuilderImpl implements EnvironmentalProductComplaincePeriod.EnvironmentalProductComplaincePeriodBuilder {
	
		protected Integer startYear;
		protected Integer endYear;
	
		public EnvironmentalProductComplaincePeriodBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("startYear")
		public Integer getStartYear() {
			return startYear;
		}
		
		@Override
		@RosettaAttribute("endYear")
		public Integer getEndYear() {
			return endYear;
		}
		
		@Override
		@RosettaAttribute("startYear")
		public EnvironmentalProductComplaincePeriod.EnvironmentalProductComplaincePeriodBuilder setStartYear(Integer startYear) {
			this.startYear = startYear==null?null:startYear;
			return this;
		}
		@Override
		@RosettaAttribute("endYear")
		public EnvironmentalProductComplaincePeriod.EnvironmentalProductComplaincePeriodBuilder setEndYear(Integer endYear) {
			this.endYear = endYear==null?null:endYear;
			return this;
		}
		
		@Override
		public EnvironmentalProductComplaincePeriod build() {
			return new EnvironmentalProductComplaincePeriod.EnvironmentalProductComplaincePeriodImpl(this);
		}
		
		@Override
		public EnvironmentalProductComplaincePeriod.EnvironmentalProductComplaincePeriodBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EnvironmentalProductComplaincePeriod.EnvironmentalProductComplaincePeriodBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getStartYear()!=null) return true;
			if (getEndYear()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EnvironmentalProductComplaincePeriod.EnvironmentalProductComplaincePeriodBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			EnvironmentalProductComplaincePeriod.EnvironmentalProductComplaincePeriodBuilder o = (EnvironmentalProductComplaincePeriod.EnvironmentalProductComplaincePeriodBuilder) other;
			
			
			merger.mergeBasic(getStartYear(), o.getStartYear(), this::setStartYear);
			merger.mergeBasic(getEndYear(), o.getEndYear(), this::setEndYear);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EnvironmentalProductComplaincePeriod _that = getType().cast(o);
		
			if (!Objects.equals(startYear, _that.getStartYear())) return false;
			if (!Objects.equals(endYear, _that.getEndYear())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (startYear != null ? startYear.hashCode() : 0);
			_result = 31 * _result + (endYear != null ? endYear.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EnvironmentalProductComplaincePeriodBuilder {" +
				"startYear=" + this.startYear + ", " +
				"endYear=" + this.endYear +
			'}';
		}
	}
}
