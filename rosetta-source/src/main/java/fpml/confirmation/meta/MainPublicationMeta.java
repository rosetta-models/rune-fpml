package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.MainPublication;
import fpml.confirmation.validation.MainPublicationTypeFormatValidator;
import fpml.confirmation.validation.MainPublicationValidator;
import fpml.confirmation.validation.exists.MainPublicationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=MainPublication.class)
public class MainPublicationMeta implements RosettaMetaData<MainPublication> {

	@Override
	public List<Validator<? super MainPublication>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super MainPublication, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super MainPublication> validator() {
		return new MainPublicationValidator();
	}

	@Override
	public Validator<? super MainPublication> typeFormatValidator() {
		return new MainPublicationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MainPublication, Set<String>> onlyExistsValidator() {
		return new MainPublicationOnlyExistsValidator();
	}
}
