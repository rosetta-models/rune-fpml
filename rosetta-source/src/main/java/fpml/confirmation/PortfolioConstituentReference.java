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
import fpml.confirmation.PortfolioConstituentReference;
import fpml.confirmation.PortfolioConstituentReference.PortfolioConstituentReferenceBuilder;
import fpml.confirmation.PortfolioConstituentReference.PortfolioConstituentReferenceBuilderImpl;
import fpml.confirmation.PortfolioConstituentReference.PortfolioConstituentReferenceImpl;
import fpml.confirmation.PortfolioName;
import fpml.confirmation.PortfolioReferenceBase;
import fpml.confirmation.PortfolioReferenceBase.PortfolioReferenceBaseBuilder;
import fpml.confirmation.PortfolioReferenceBase.PortfolioReferenceBaseBuilderImpl;
import fpml.confirmation.PortfolioReferenceBase.PortfolioReferenceBaseImpl;
import fpml.confirmation.meta.PortfolioConstituentReferenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A structure used to group together individual messages that can be acted on at a group level.
 * @version ${project.version}
 */
@RosettaDataType(value="PortfolioConstituentReference", builder=PortfolioConstituentReference.PortfolioConstituentReferenceBuilderImpl.class, version="${project.version}")
public interface PortfolioConstituentReference extends PortfolioReferenceBase {

	PortfolioConstituentReferenceMeta metaData = new PortfolioConstituentReferenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A numeric, sequentially ascending (i.e. gapless) value (starting at 1) that can be used to identify and distinguish the individual constituents of a portfolio request. A recipient should ensure that all sequence numbers from 1 to the final sequence number (where submissionsComplete is true) have arrived before completing the portfolio request.
	 */
	Integer getSequenceNumber();

	/*********************** Build Methods  ***********************/
	PortfolioConstituentReference build();
	
	PortfolioConstituentReference.PortfolioConstituentReferenceBuilder toBuilder();
	
	static PortfolioConstituentReference.PortfolioConstituentReferenceBuilder builder() {
		return new PortfolioConstituentReference.PortfolioConstituentReferenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PortfolioConstituentReference> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PortfolioConstituentReference> getType() {
		return PortfolioConstituentReference.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("portfolioName"), processor, PortfolioName.class, getPortfolioName());
		processor.processBasic(path.newSubPath("sequenceNumber"), Integer.class, getSequenceNumber(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PortfolioConstituentReferenceBuilder extends PortfolioConstituentReference, PortfolioReferenceBase.PortfolioReferenceBaseBuilder {
		PortfolioConstituentReference.PortfolioConstituentReferenceBuilder setPortfolioName(PortfolioName portfolioName);
		PortfolioConstituentReference.PortfolioConstituentReferenceBuilder setSequenceNumber(Integer sequenceNumber);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("portfolioName"), processor, PortfolioName.PortfolioNameBuilder.class, getPortfolioName());
			processor.processBasic(path.newSubPath("sequenceNumber"), Integer.class, getSequenceNumber(), this);
		}
		

		PortfolioConstituentReference.PortfolioConstituentReferenceBuilder prune();
	}

	/*********************** Immutable Implementation of PortfolioConstituentReference  ***********************/
	class PortfolioConstituentReferenceImpl extends PortfolioReferenceBase.PortfolioReferenceBaseImpl implements PortfolioConstituentReference {
		private final Integer sequenceNumber;
		
		protected PortfolioConstituentReferenceImpl(PortfolioConstituentReference.PortfolioConstituentReferenceBuilder builder) {
			super(builder);
			this.sequenceNumber = builder.getSequenceNumber();
		}
		
		@Override
		@RosettaAttribute("sequenceNumber")
		public Integer getSequenceNumber() {
			return sequenceNumber;
		}
		
		@Override
		public PortfolioConstituentReference build() {
			return this;
		}
		
		@Override
		public PortfolioConstituentReference.PortfolioConstituentReferenceBuilder toBuilder() {
			PortfolioConstituentReference.PortfolioConstituentReferenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PortfolioConstituentReference.PortfolioConstituentReferenceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getSequenceNumber()).ifPresent(builder::setSequenceNumber);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			PortfolioConstituentReference _that = getType().cast(o);
		
			if (!Objects.equals(sequenceNumber, _that.getSequenceNumber())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (sequenceNumber != null ? sequenceNumber.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PortfolioConstituentReference {" +
				"sequenceNumber=" + this.sequenceNumber +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of PortfolioConstituentReference  ***********************/
	class PortfolioConstituentReferenceBuilderImpl extends PortfolioReferenceBase.PortfolioReferenceBaseBuilderImpl  implements PortfolioConstituentReference.PortfolioConstituentReferenceBuilder {
	
		protected Integer sequenceNumber;
	
		public PortfolioConstituentReferenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("sequenceNumber")
		public Integer getSequenceNumber() {
			return sequenceNumber;
		}
		
		@Override
		@RosettaAttribute("portfolioName")
		public PortfolioConstituentReference.PortfolioConstituentReferenceBuilder setPortfolioName(PortfolioName portfolioName) {
			this.portfolioName = portfolioName==null?null:portfolioName.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("sequenceNumber")
		public PortfolioConstituentReference.PortfolioConstituentReferenceBuilder setSequenceNumber(Integer sequenceNumber) {
			this.sequenceNumber = sequenceNumber==null?null:sequenceNumber;
			return this;
		}
		
		@Override
		public PortfolioConstituentReference build() {
			return new PortfolioConstituentReference.PortfolioConstituentReferenceImpl(this);
		}
		
		@Override
		public PortfolioConstituentReference.PortfolioConstituentReferenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PortfolioConstituentReference.PortfolioConstituentReferenceBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getSequenceNumber()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PortfolioConstituentReference.PortfolioConstituentReferenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			PortfolioConstituentReference.PortfolioConstituentReferenceBuilder o = (PortfolioConstituentReference.PortfolioConstituentReferenceBuilder) other;
			
			
			merger.mergeBasic(getSequenceNumber(), o.getSequenceNumber(), this::setSequenceNumber);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			PortfolioConstituentReference _that = getType().cast(o);
		
			if (!Objects.equals(sequenceNumber, _that.getSequenceNumber())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (sequenceNumber != null ? sequenceNumber.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PortfolioConstituentReferenceBuilder {" +
				"sequenceNumber=" + this.sequenceNumber +
			'}' + " " + super.toString();
		}
	}
}
