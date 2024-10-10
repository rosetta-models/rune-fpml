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
import fpml.confirmation.AverageDailyTradingVolumeLimit;
import fpml.confirmation.AverageDailyTradingVolumeLimit.AverageDailyTradingVolumeLimitBuilder;
import fpml.confirmation.AverageDailyTradingVolumeLimit.AverageDailyTradingVolumeLimitBuilderImpl;
import fpml.confirmation.AverageDailyTradingVolumeLimit.AverageDailyTradingVolumeLimitImpl;
import fpml.confirmation.meta.AverageDailyTradingVolumeLimitMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * To indicate the limitation percentage and limitation period.
 * @version ${project.version}
 */
@RosettaDataType(value="AverageDailyTradingVolumeLimit", builder=AverageDailyTradingVolumeLimit.AverageDailyTradingVolumeLimitBuilderImpl.class, version="${project.version}")
public interface AverageDailyTradingVolumeLimit extends RosettaModelObject {

	AverageDailyTradingVolumeLimitMeta metaData = new AverageDailyTradingVolumeLimitMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies the limitation percentage in Average Daily trading volume.
	 */
	BigDecimal getLimitationPercentage();
	/**
	 * Specifies the limitation period for Average Daily trading volume in number of days.
	 */
	Integer getLimitationPeriod();

	/*********************** Build Methods  ***********************/
	AverageDailyTradingVolumeLimit build();
	
	AverageDailyTradingVolumeLimit.AverageDailyTradingVolumeLimitBuilder toBuilder();
	
	static AverageDailyTradingVolumeLimit.AverageDailyTradingVolumeLimitBuilder builder() {
		return new AverageDailyTradingVolumeLimit.AverageDailyTradingVolumeLimitBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AverageDailyTradingVolumeLimit> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends AverageDailyTradingVolumeLimit> getType() {
		return AverageDailyTradingVolumeLimit.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("limitationPercentage"), BigDecimal.class, getLimitationPercentage(), this);
		processor.processBasic(path.newSubPath("limitationPeriod"), Integer.class, getLimitationPeriod(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AverageDailyTradingVolumeLimitBuilder extends AverageDailyTradingVolumeLimit, RosettaModelObjectBuilder {
		AverageDailyTradingVolumeLimit.AverageDailyTradingVolumeLimitBuilder setLimitationPercentage(BigDecimal limitationPercentage);
		AverageDailyTradingVolumeLimit.AverageDailyTradingVolumeLimitBuilder setLimitationPeriod(Integer limitationPeriod);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("limitationPercentage"), BigDecimal.class, getLimitationPercentage(), this);
			processor.processBasic(path.newSubPath("limitationPeriod"), Integer.class, getLimitationPeriod(), this);
		}
		

		AverageDailyTradingVolumeLimit.AverageDailyTradingVolumeLimitBuilder prune();
	}

	/*********************** Immutable Implementation of AverageDailyTradingVolumeLimit  ***********************/
	class AverageDailyTradingVolumeLimitImpl implements AverageDailyTradingVolumeLimit {
		private final BigDecimal limitationPercentage;
		private final Integer limitationPeriod;
		
		protected AverageDailyTradingVolumeLimitImpl(AverageDailyTradingVolumeLimit.AverageDailyTradingVolumeLimitBuilder builder) {
			this.limitationPercentage = builder.getLimitationPercentage();
			this.limitationPeriod = builder.getLimitationPeriod();
		}
		
		@Override
		@RosettaAttribute("limitationPercentage")
		public BigDecimal getLimitationPercentage() {
			return limitationPercentage;
		}
		
		@Override
		@RosettaAttribute("limitationPeriod")
		public Integer getLimitationPeriod() {
			return limitationPeriod;
		}
		
		@Override
		public AverageDailyTradingVolumeLimit build() {
			return this;
		}
		
		@Override
		public AverageDailyTradingVolumeLimit.AverageDailyTradingVolumeLimitBuilder toBuilder() {
			AverageDailyTradingVolumeLimit.AverageDailyTradingVolumeLimitBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AverageDailyTradingVolumeLimit.AverageDailyTradingVolumeLimitBuilder builder) {
			ofNullable(getLimitationPercentage()).ifPresent(builder::setLimitationPercentage);
			ofNullable(getLimitationPeriod()).ifPresent(builder::setLimitationPeriod);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AverageDailyTradingVolumeLimit _that = getType().cast(o);
		
			if (!Objects.equals(limitationPercentage, _that.getLimitationPercentage())) return false;
			if (!Objects.equals(limitationPeriod, _that.getLimitationPeriod())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (limitationPercentage != null ? limitationPercentage.hashCode() : 0);
			_result = 31 * _result + (limitationPeriod != null ? limitationPeriod.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AverageDailyTradingVolumeLimit {" +
				"limitationPercentage=" + this.limitationPercentage + ", " +
				"limitationPeriod=" + this.limitationPeriod +
			'}';
		}
	}

	/*********************** Builder Implementation of AverageDailyTradingVolumeLimit  ***********************/
	class AverageDailyTradingVolumeLimitBuilderImpl implements AverageDailyTradingVolumeLimit.AverageDailyTradingVolumeLimitBuilder {
	
		protected BigDecimal limitationPercentage;
		protected Integer limitationPeriod;
	
		public AverageDailyTradingVolumeLimitBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("limitationPercentage")
		public BigDecimal getLimitationPercentage() {
			return limitationPercentage;
		}
		
		@Override
		@RosettaAttribute("limitationPeriod")
		public Integer getLimitationPeriod() {
			return limitationPeriod;
		}
		
		@Override
		@RosettaAttribute("limitationPercentage")
		public AverageDailyTradingVolumeLimit.AverageDailyTradingVolumeLimitBuilder setLimitationPercentage(BigDecimal limitationPercentage) {
			this.limitationPercentage = limitationPercentage==null?null:limitationPercentage;
			return this;
		}
		@Override
		@RosettaAttribute("limitationPeriod")
		public AverageDailyTradingVolumeLimit.AverageDailyTradingVolumeLimitBuilder setLimitationPeriod(Integer limitationPeriod) {
			this.limitationPeriod = limitationPeriod==null?null:limitationPeriod;
			return this;
		}
		
		@Override
		public AverageDailyTradingVolumeLimit build() {
			return new AverageDailyTradingVolumeLimit.AverageDailyTradingVolumeLimitImpl(this);
		}
		
		@Override
		public AverageDailyTradingVolumeLimit.AverageDailyTradingVolumeLimitBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AverageDailyTradingVolumeLimit.AverageDailyTradingVolumeLimitBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getLimitationPercentage()!=null) return true;
			if (getLimitationPeriod()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AverageDailyTradingVolumeLimit.AverageDailyTradingVolumeLimitBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AverageDailyTradingVolumeLimit.AverageDailyTradingVolumeLimitBuilder o = (AverageDailyTradingVolumeLimit.AverageDailyTradingVolumeLimitBuilder) other;
			
			
			merger.mergeBasic(getLimitationPercentage(), o.getLimitationPercentage(), this::setLimitationPercentage);
			merger.mergeBasic(getLimitationPeriod(), o.getLimitationPeriod(), this::setLimitationPeriod);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AverageDailyTradingVolumeLimit _that = getType().cast(o);
		
			if (!Objects.equals(limitationPercentage, _that.getLimitationPercentage())) return false;
			if (!Objects.equals(limitationPeriod, _that.getLimitationPeriod())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (limitationPercentage != null ? limitationPercentage.hashCode() : 0);
			_result = 31 * _result + (limitationPeriod != null ? limitationPeriod.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AverageDailyTradingVolumeLimitBuilder {" +
				"limitationPercentage=" + this.limitationPercentage + ", " +
				"limitationPeriod=" + this.limitationPeriod +
			'}';
		}
	}
}
