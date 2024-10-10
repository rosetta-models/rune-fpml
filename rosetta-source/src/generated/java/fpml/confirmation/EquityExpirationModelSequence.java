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
import fpml.confirmation.BusinessCenterTime;
import fpml.confirmation.EquityExpirationModelSequence;
import fpml.confirmation.EquityExpirationModelSequence.EquityExpirationModelSequenceBuilder;
import fpml.confirmation.EquityExpirationModelSequence.EquityExpirationModelSequenceBuilderImpl;
import fpml.confirmation.EquityExpirationModelSequence.EquityExpirationModelSequenceImpl;
import fpml.confirmation.TimeTypeEnum;
import fpml.confirmation.meta.EquityExpirationModelSequenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="EquityExpirationModelSequence", builder=EquityExpirationModelSequence.EquityExpirationModelSequenceBuilderImpl.class, version="${project.version}")
public interface EquityExpirationModelSequence extends RosettaModelObject {

	EquityExpirationModelSequenceMeta metaData = new EquityExpirationModelSequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The time of day at which the equity option expires, for example the official closing time of the exchange.
	 */
	TimeTypeEnum getEquityExpirationTimeType();
	/**
	 * The specific time of day at which the equity option expires.
	 */
	BusinessCenterTime getEquityExpirationTime();

	/*********************** Build Methods  ***********************/
	EquityExpirationModelSequence build();
	
	EquityExpirationModelSequence.EquityExpirationModelSequenceBuilder toBuilder();
	
	static EquityExpirationModelSequence.EquityExpirationModelSequenceBuilder builder() {
		return new EquityExpirationModelSequence.EquityExpirationModelSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EquityExpirationModelSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends EquityExpirationModelSequence> getType() {
		return EquityExpirationModelSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("equityExpirationTimeType"), TimeTypeEnum.class, getEquityExpirationTimeType(), this);
		processRosetta(path.newSubPath("equityExpirationTime"), processor, BusinessCenterTime.class, getEquityExpirationTime());
	}
	

	/*********************** Builder Interface  ***********************/
	interface EquityExpirationModelSequenceBuilder extends EquityExpirationModelSequence, RosettaModelObjectBuilder {
		BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateEquityExpirationTime();
		BusinessCenterTime.BusinessCenterTimeBuilder getEquityExpirationTime();
		EquityExpirationModelSequence.EquityExpirationModelSequenceBuilder setEquityExpirationTimeType(TimeTypeEnum equityExpirationTimeType);
		EquityExpirationModelSequence.EquityExpirationModelSequenceBuilder setEquityExpirationTime(BusinessCenterTime equityExpirationTime);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("equityExpirationTimeType"), TimeTypeEnum.class, getEquityExpirationTimeType(), this);
			processRosetta(path.newSubPath("equityExpirationTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getEquityExpirationTime());
		}
		

		EquityExpirationModelSequence.EquityExpirationModelSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of EquityExpirationModelSequence  ***********************/
	class EquityExpirationModelSequenceImpl implements EquityExpirationModelSequence {
		private final TimeTypeEnum equityExpirationTimeType;
		private final BusinessCenterTime equityExpirationTime;
		
		protected EquityExpirationModelSequenceImpl(EquityExpirationModelSequence.EquityExpirationModelSequenceBuilder builder) {
			this.equityExpirationTimeType = builder.getEquityExpirationTimeType();
			this.equityExpirationTime = ofNullable(builder.getEquityExpirationTime()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("equityExpirationTimeType")
		public TimeTypeEnum getEquityExpirationTimeType() {
			return equityExpirationTimeType;
		}
		
		@Override
		@RosettaAttribute("equityExpirationTime")
		public BusinessCenterTime getEquityExpirationTime() {
			return equityExpirationTime;
		}
		
		@Override
		public EquityExpirationModelSequence build() {
			return this;
		}
		
		@Override
		public EquityExpirationModelSequence.EquityExpirationModelSequenceBuilder toBuilder() {
			EquityExpirationModelSequence.EquityExpirationModelSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EquityExpirationModelSequence.EquityExpirationModelSequenceBuilder builder) {
			ofNullable(getEquityExpirationTimeType()).ifPresent(builder::setEquityExpirationTimeType);
			ofNullable(getEquityExpirationTime()).ifPresent(builder::setEquityExpirationTime);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EquityExpirationModelSequence _that = getType().cast(o);
		
			if (!Objects.equals(equityExpirationTimeType, _that.getEquityExpirationTimeType())) return false;
			if (!Objects.equals(equityExpirationTime, _that.getEquityExpirationTime())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (equityExpirationTimeType != null ? equityExpirationTimeType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (equityExpirationTime != null ? equityExpirationTime.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EquityExpirationModelSequence {" +
				"equityExpirationTimeType=" + this.equityExpirationTimeType + ", " +
				"equityExpirationTime=" + this.equityExpirationTime +
			'}';
		}
	}

	/*********************** Builder Implementation of EquityExpirationModelSequence  ***********************/
	class EquityExpirationModelSequenceBuilderImpl implements EquityExpirationModelSequence.EquityExpirationModelSequenceBuilder {
	
		protected TimeTypeEnum equityExpirationTimeType;
		protected BusinessCenterTime.BusinessCenterTimeBuilder equityExpirationTime;
	
		public EquityExpirationModelSequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("equityExpirationTimeType")
		public TimeTypeEnum getEquityExpirationTimeType() {
			return equityExpirationTimeType;
		}
		
		@Override
		@RosettaAttribute("equityExpirationTime")
		public BusinessCenterTime.BusinessCenterTimeBuilder getEquityExpirationTime() {
			return equityExpirationTime;
		}
		
		@Override
		public BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateEquityExpirationTime() {
			BusinessCenterTime.BusinessCenterTimeBuilder result;
			if (equityExpirationTime!=null) {
				result = equityExpirationTime;
			}
			else {
				result = equityExpirationTime = BusinessCenterTime.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("equityExpirationTimeType")
		public EquityExpirationModelSequence.EquityExpirationModelSequenceBuilder setEquityExpirationTimeType(TimeTypeEnum equityExpirationTimeType) {
			this.equityExpirationTimeType = equityExpirationTimeType==null?null:equityExpirationTimeType;
			return this;
		}
		@Override
		@RosettaAttribute("equityExpirationTime")
		public EquityExpirationModelSequence.EquityExpirationModelSequenceBuilder setEquityExpirationTime(BusinessCenterTime equityExpirationTime) {
			this.equityExpirationTime = equityExpirationTime==null?null:equityExpirationTime.toBuilder();
			return this;
		}
		
		@Override
		public EquityExpirationModelSequence build() {
			return new EquityExpirationModelSequence.EquityExpirationModelSequenceImpl(this);
		}
		
		@Override
		public EquityExpirationModelSequence.EquityExpirationModelSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EquityExpirationModelSequence.EquityExpirationModelSequenceBuilder prune() {
			if (equityExpirationTime!=null && !equityExpirationTime.prune().hasData()) equityExpirationTime = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getEquityExpirationTimeType()!=null) return true;
			if (getEquityExpirationTime()!=null && getEquityExpirationTime().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EquityExpirationModelSequence.EquityExpirationModelSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			EquityExpirationModelSequence.EquityExpirationModelSequenceBuilder o = (EquityExpirationModelSequence.EquityExpirationModelSequenceBuilder) other;
			
			merger.mergeRosetta(getEquityExpirationTime(), o.getEquityExpirationTime(), this::setEquityExpirationTime);
			
			merger.mergeBasic(getEquityExpirationTimeType(), o.getEquityExpirationTimeType(), this::setEquityExpirationTimeType);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EquityExpirationModelSequence _that = getType().cast(o);
		
			if (!Objects.equals(equityExpirationTimeType, _that.getEquityExpirationTimeType())) return false;
			if (!Objects.equals(equityExpirationTime, _that.getEquityExpirationTime())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (equityExpirationTimeType != null ? equityExpirationTimeType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (equityExpirationTime != null ? equityExpirationTime.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EquityExpirationModelSequenceBuilder {" +
				"equityExpirationTimeType=" + this.equityExpirationTimeType + ", " +
				"equityExpirationTime=" + this.equityExpirationTime +
			'}';
		}
	}
}
