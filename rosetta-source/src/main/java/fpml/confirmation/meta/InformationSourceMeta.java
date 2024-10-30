package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.InformationSource;
import fpml.confirmation.validation.InformationSourceTypeFormatValidator;
import fpml.confirmation.validation.InformationSourceValidator;
import fpml.confirmation.validation.exists.InformationSourceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=InformationSource.class)
public class InformationSourceMeta implements RosettaMetaData<InformationSource> {

	@Override
	public List<Validator<? super InformationSource>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super InformationSource, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super InformationSource> validator() {
		return new InformationSourceValidator();
	}

	@Override
	public Validator<? super InformationSource> typeFormatValidator() {
		return new InformationSourceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super InformationSource, Set<String>> onlyExistsValidator() {
		return new InformationSourceOnlyExistsValidator();
	}
}
