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
import fpml.confirmation.PortfolioName;
import fpml.confirmation.PortfolioReferenceBase;
import fpml.confirmation.PortfolioReferenceBase.PortfolioReferenceBaseBuilder;
import fpml.confirmation.PortfolioReferenceBase.PortfolioReferenceBaseBuilderImpl;
import fpml.confirmation.PortfolioReferenceBase.PortfolioReferenceBaseImpl;
import fpml.confirmation.meta.PortfolioReferenceBaseMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A structure used to identify a portfolio in a message.
 * @version ${project.version}
 */
@RosettaDataType(value="PortfolioReferenceBase", builder=PortfolioReferenceBase.PortfolioReferenceBaseBuilderImpl.class, version="${project.version}")
public interface PortfolioReferenceBase extends RosettaModelObject {

	PortfolioReferenceBaseMeta metaData = new PortfolioReferenceBaseMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * An identifier that is unique for each portfolio-level request, and which can be used to group together the individual messages in the portfolio request.
	 */
	PortfolioName getPortfolioName();

	/*********************** Build Methods  ***********************/
	PortfolioReferenceBase build();
	
	PortfolioReferenceBase.PortfolioReferenceBaseBuilder toBuilder();
	
	static PortfolioReferenceBase.PortfolioReferenceBaseBuilder builder() {
		return new PortfolioReferenceBase.PortfolioReferenceBaseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PortfolioReferenceBase> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PortfolioReferenceBase> getType() {
		return PortfolioReferenceBase.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("portfolioName"), processor, PortfolioName.class, getPortfolioName());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PortfolioReferenceBaseBuilder extends PortfolioReferenceBase, RosettaModelObjectBuilder {
		PortfolioName.PortfolioNameBuilder getOrCreatePortfolioName();
		PortfolioName.PortfolioNameBuilder getPortfolioName();
		PortfolioReferenceBase.PortfolioReferenceBaseBuilder setPortfolioName(PortfolioName portfolioName);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("portfolioName"), processor, PortfolioName.PortfolioNameBuilder.class, getPortfolioName());
		}
		

		PortfolioReferenceBase.PortfolioReferenceBaseBuilder prune();
	}

	/*********************** Immutable Implementation of PortfolioReferenceBase  ***********************/
	class PortfolioReferenceBaseImpl implements PortfolioReferenceBase {
		private final PortfolioName portfolioName;
		
		protected PortfolioReferenceBaseImpl(PortfolioReferenceBase.PortfolioReferenceBaseBuilder builder) {
			this.portfolioName = ofNullable(builder.getPortfolioName()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("portfolioName")
		public PortfolioName getPortfolioName() {
			return portfolioName;
		}
		
		@Override
		public PortfolioReferenceBase build() {
			return this;
		}
		
		@Override
		public PortfolioReferenceBase.PortfolioReferenceBaseBuilder toBuilder() {
			PortfolioReferenceBase.PortfolioReferenceBaseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PortfolioReferenceBase.PortfolioReferenceBaseBuilder builder) {
			ofNullable(getPortfolioName()).ifPresent(builder::setPortfolioName);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PortfolioReferenceBase _that = getType().cast(o);
		
			if (!Objects.equals(portfolioName, _that.getPortfolioName())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (portfolioName != null ? portfolioName.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PortfolioReferenceBase {" +
				"portfolioName=" + this.portfolioName +
			'}';
		}
	}

	/*********************** Builder Implementation of PortfolioReferenceBase  ***********************/
	class PortfolioReferenceBaseBuilderImpl implements PortfolioReferenceBase.PortfolioReferenceBaseBuilder {
	
		protected PortfolioName.PortfolioNameBuilder portfolioName;
	
		public PortfolioReferenceBaseBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("portfolioName")
		public PortfolioName.PortfolioNameBuilder getPortfolioName() {
			return portfolioName;
		}
		
		@Override
		public PortfolioName.PortfolioNameBuilder getOrCreatePortfolioName() {
			PortfolioName.PortfolioNameBuilder result;
			if (portfolioName!=null) {
				result = portfolioName;
			}
			else {
				result = portfolioName = PortfolioName.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("portfolioName")
		public PortfolioReferenceBase.PortfolioReferenceBaseBuilder setPortfolioName(PortfolioName portfolioName) {
			this.portfolioName = portfolioName==null?null:portfolioName.toBuilder();
			return this;
		}
		
		@Override
		public PortfolioReferenceBase build() {
			return new PortfolioReferenceBase.PortfolioReferenceBaseImpl(this);
		}
		
		@Override
		public PortfolioReferenceBase.PortfolioReferenceBaseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PortfolioReferenceBase.PortfolioReferenceBaseBuilder prune() {
			if (portfolioName!=null && !portfolioName.prune().hasData()) portfolioName = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPortfolioName()!=null && getPortfolioName().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PortfolioReferenceBase.PortfolioReferenceBaseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PortfolioReferenceBase.PortfolioReferenceBaseBuilder o = (PortfolioReferenceBase.PortfolioReferenceBaseBuilder) other;
			
			merger.mergeRosetta(getPortfolioName(), o.getPortfolioName(), this::setPortfolioName);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PortfolioReferenceBase _that = getType().cast(o);
		
			if (!Objects.equals(portfolioName, _that.getPortfolioName())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (portfolioName != null ? portfolioName.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PortfolioReferenceBaseBuilder {" +
				"portfolioName=" + this.portfolioName +
			'}';
		}
	}
}
